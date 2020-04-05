package pl.lodz.p.edu.dliwocha.geofence.api.configuration.security

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import pl.lodz.p.edu.dliwocha.geofence.api.configuration.exception.ExceptionFilter
import pl.lodz.p.edu.dliwocha.geofence.api.configuration.jwt.JwtFilter
import pl.lodz.p.edu.dliwocha.geofence.api.configuration.jwt.JwtProvider
import pl.lodz.p.edu.dliwocha.geofence.api.service.AuthenticationService


class SecurityConfiguration(
        private val jwtProvider: JwtProvider,
        private val authenticationService: AuthenticationService
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(http: HttpSecurity) {
        http.addFilterBefore(JwtFilter(jwtProvider, authenticationService), UsernamePasswordAuthenticationFilter::class.java)
        http.addFilterBefore(ExceptionFilter(), JwtFilter::class.java)
    }

}