package pl.lodz.p.edu.dliwocha.geofence.api.controller

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
@RequestMapping("/management")
class ManagementController {

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    fun healthCheck() {
    }

}


