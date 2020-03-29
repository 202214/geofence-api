package pl.lodz.p.edu.dliwocha.geofence.api.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "location_t")
data class Location(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "configuration_id")
        val configuration: Configuration,

        @Basic
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "date")
        val date: Date,

        @Column(name = "accuracy")
        val latitude: Double,

        @Column(name = "latitude")
        val longitude: Double,

        @Column(name = "altitude")
        val altitude: Double,

        @Column(name = "accuracy")
        val accuracy: Double,

        @Column(name = "position_interval_in_minutes")
        val positionIntervalInMinutes: Int

)