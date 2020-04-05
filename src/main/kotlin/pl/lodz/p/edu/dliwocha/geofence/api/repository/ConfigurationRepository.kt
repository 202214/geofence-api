package pl.lodz.p.edu.dliwocha.geofence.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.lodz.p.edu.dliwocha.geofence.api.entity.Configuration

interface ConfigurationRepository : JpaRepository<Configuration, Long> {

    fun findByExternalId(externalId: String): Configuration?

    fun findByTrackedObjectId(trackedObjectId: String): Configuration

}