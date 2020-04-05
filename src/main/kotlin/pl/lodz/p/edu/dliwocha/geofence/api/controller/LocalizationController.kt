package pl.lodz.p.edu.dliwocha.geofence.api.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.lodz.p.edu.dliwocha.geofence.api.dto.LocalizationDto
import pl.lodz.p.edu.dliwocha.geofence.api.service.LocalizationService

@RestController
@RequestMapping("/localization")
class LocalizationController(
        private val localizationService: LocalizationService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun reportLocalization(@RequestBody localizationDto: LocalizationDto) {
        localizationService.reportLocalization(localizationDto)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun test(): String {
        return "test"
    }

}


