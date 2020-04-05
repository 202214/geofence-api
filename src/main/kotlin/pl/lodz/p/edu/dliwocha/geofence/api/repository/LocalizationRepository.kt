package pl.lodz.p.edu.dliwocha.geofence.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.lodz.p.edu.dliwocha.geofence.api.entity.Localization

interface LocalizationRepository : JpaRepository<Localization, Long>