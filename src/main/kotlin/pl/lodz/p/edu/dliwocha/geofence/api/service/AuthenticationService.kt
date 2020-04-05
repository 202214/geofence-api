package pl.lodz.p.edu.dliwocha.geofence.api.service

import io.jsonwebtoken.Jwts
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import pl.lodz.p.edu.dliwocha.geofence.api.repository.ConfigurationRepository
import pl.lodz.p.edu.dliwocha.geofence.api.configuration.security.AuthenticationDetails
import pl.lodz.p.edu.dliwocha.geofence.api.configuration.jwt.JwtConstants
import pl.lodz.p.edu.dliwocha.geofence.api.configuration.jwt.JwtProvider

@Service
@Transactional
class AuthenticationService(
        private val authenticationManager: AuthenticationManager,
        private val jwtProvider: JwtProvider,
        private val configurationRepository: ConfigurationRepository
) : UserDetailsService {

    override fun loadUserByUsername(externalId: String): UserDetails {
        val configuration = configurationRepository.findByExternalId(externalId)

        if (configuration == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }

        return AuthenticationDetails(configuration)
    }

    fun authenticate(configurationExternalId: String): String {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(configurationExternalId, configurationExternalId))
        return jwtProvider.createToken(configurationExternalId)
    }

    fun getAuthentication(token: String): Authentication {
        val userDetails: UserDetails = loadUserByUsername(getConfigurationExternalId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getConfigurationExternalId(token: String): String {
        return Jwts.parser().setSigningKey(JwtConstants.tokenSecret).parseClaimsJws(token).getBody().getSubject()
    }

}