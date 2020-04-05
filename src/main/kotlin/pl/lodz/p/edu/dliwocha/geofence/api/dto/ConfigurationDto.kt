package pl.lodz.p.edu.dliwocha.geofence.api.dto

data class ConfigurationDto(
        val name: String,
        val token: String,
        val trackedObjectId: String,
        val positionIntervalInMinutes: Int
)