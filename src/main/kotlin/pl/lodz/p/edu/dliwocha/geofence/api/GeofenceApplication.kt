package pl.lodz.p.edu.dliwocha.geofence.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GeofenceApplication

fun main(args: Array<String>) {
    runApplication<GeofenceApplication>(*args)
}
