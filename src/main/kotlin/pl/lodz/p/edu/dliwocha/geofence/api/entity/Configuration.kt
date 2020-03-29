package pl.lodz.p.edu.dliwocha.geofence.api.entity

import javax.persistence.*

@Entity
@Table(name = "configuration_t")
data class Configuration(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "external_id")
        val externalId: String,

        @Column(name = "tracked_object_id")
        val trackedObjectId: String,

        @Column(name = "name")
        val name: String,

        @Column(name = "position_interval") // in minutes
        val positionInterval: Int

)