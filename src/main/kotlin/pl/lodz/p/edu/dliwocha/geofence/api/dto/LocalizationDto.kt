package pl.lodz.p.edu.dliwocha.geofence.api.dto

data class LocalizationDto(
        val token: String,
        val accuracy: Double,
        val altitude: Double,
        val latitude: Double,
        val longitude: Double,
        val timestamp: Long,
        val trackedObjectId: String
)