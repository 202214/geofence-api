package pl.lodz.p.edu.dliwocha.geofence.api.configuration.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import pl.lodz.p.edu.dliwocha.geofence.api.entity.Configuration

class AuthenticationDetails(
        private val configuration: Configuration
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return configuration.externalId
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return "{noop}" + configuration.externalId
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

}