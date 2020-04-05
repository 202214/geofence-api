package pl.lodz.p.edu.dliwocha.geofence.api.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.lodz.p.edu.dliwocha.geofence.api.dto.ConfigurationDto
import pl.lodz.p.edu.dliwocha.geofence.api.service.ConfigurationService

@RestController
@RequestMapping("/configuration")
class ConfigurationController(
        private val configurationService: ConfigurationService
) {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun loadConfiguration(@PathVariable id: String): ConfigurationDto {
        return configurationService.loadConfiguration(id)
    }

}


