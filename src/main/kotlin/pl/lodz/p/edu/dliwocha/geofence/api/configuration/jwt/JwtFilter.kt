package pl.lodz.p.edu.dliwocha.geofence.api.configuration.jwt

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import pl.lodz.p.edu.dliwocha.geofence.api.service.AuthenticationService
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtFilter(
        private val jwtProvider: JwtProvider,
        private val authenticationService: AuthenticationService
) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest, response: ServletResponse, filterChain: FilterChain) {
        val token = jwtProvider.resolveToken(request as HttpServletRequest)
        if (token != null && jwtProvider.validateToken(token)) {
            SecurityContextHolder.getContext().authentication = authenticationService.getAuthentication(token);
        }
        filterChain.doFilter(request, response);
    }

}