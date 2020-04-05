package pl.lodz.p.edu.dliwocha.geofence.api.configuration.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.TimeUnit
import javax.servlet.http.HttpServletRequest

@Component
class JwtProvider {

    fun createToken(username: String): String {
        val claims = Jwts.claims().setSubject(username)
        val expiration = Date(Date().time + TimeUnit.MINUTES.toMillis(JwtConstants.tokenExpiration))
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date())
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, JwtConstants.tokenSecret)
                .compact()
    }

    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7, bearerToken.length)
        } else {
            null
        }
    }

    fun validateToken(token: String): Boolean {
        val claims: Jws<Claims> = Jwts.parser().setSigningKey(JwtConstants.tokenSecret).parseClaimsJws(token)
        return !claims.body.expiration.before(Date())
    }

}