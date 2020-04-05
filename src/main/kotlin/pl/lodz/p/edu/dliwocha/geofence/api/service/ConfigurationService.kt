package pl.lodz.p.edu.dliwocha.geofence.api.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import pl.lodz.p.edu.dliwocha.geofence.api.dto.ConfigurationDto
import pl.lodz.p.edu.dliwocha.geofence.api.entity.Configuration
import pl.lodz.p.edu.dliwocha.geofence.api.repository.ConfigurationRepository
import java.util.*

@Service
@Transactional
class ConfigurationService(
        private val configurationRepository: ConfigurationRepository,
        private val authenticationService: AuthenticationService
) {

    fun loadConfiguration(externalId: String): ConfigurationDto {
        var configuration = configurationRepository.findByExternalId(externalId)

        if (configuration == null) {
            configuration = configurationRepository.save(createConfiguration(externalId))
        }

        val token = authenticationService.authenticate(externalId)
        return ConfigurationDto(configuration.name, token, configuration.trackedObjectId, configuration.positionInterval)
    }

    private fun createConfiguration(externalId: String): Configuration {
        return Configuration(externalId, UUID.randomUUID().toString(), externalId, (1..5).random())
    }

}