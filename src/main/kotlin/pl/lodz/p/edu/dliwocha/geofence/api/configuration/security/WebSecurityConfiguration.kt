package pl.lodz.p.edu.dliwocha.geofence.api.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import pl.lodz.p.edu.dliwocha.geofence.api.configuration.jwt.JwtProvider
import pl.lodz.p.edu.dliwocha.geofence.api.service.AuthenticationService

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(
        private val jwtProvider: JwtProvider,
        @Lazy private val authenticationService: AuthenticationService
) : WebSecurityConfigurerAdapter() {

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic().disable().csrf().disable()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/configuration/**").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().apply(SecurityConfiguration(jwtProvider, authenticationService))
    }

}