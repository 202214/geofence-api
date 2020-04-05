package pl.lodz.p.edu.dliwocha.geofence.api.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import pl.lodz.p.edu.dliwocha.geofence.api.dto.LocalizationDto
import pl.lodz.p.edu.dliwocha.geofence.api.entity.Localization
import pl.lodz.p.edu.dliwocha.geofence.api.repository.ConfigurationRepository
import pl.lodz.p.edu.dliwocha.geofence.api.repository.LocalizationRepository
import java.util.*

@Service
@Transactional
class LocalizationService(
        private val localizationRepository: LocalizationRepository,
        private val configurationRepository: ConfigurationRepository
) {

    fun reportLocalization(localizationDto: LocalizationDto) {
        localizationRepository.save(Localization(configurationRepository.findByTrackedObjectId(localizationDto.trackedObjectId),
                Date(localizationDto.timestamp), localizationDto.latitude, localizationDto.longitude,
                localizationDto.altitude, localizationDto.accuracy))
    }

}