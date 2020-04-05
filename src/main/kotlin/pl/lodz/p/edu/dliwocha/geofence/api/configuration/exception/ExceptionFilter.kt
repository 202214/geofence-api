package pl.lodz.p.edu.dliwocha.geofence.api.configuration.exception

import io.jsonwebtoken.JwtException
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response);
        } catch (e: JwtException) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(e.message)
        }
    }

}