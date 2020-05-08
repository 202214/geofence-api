package pl.lodz.p.edu.dliwocha.geofence.api.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "localization_t")
class Localization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    @ManyToOne
    @JoinColumn(name = "configuration_id")
    lateinit var configuration: Configuration

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    lateinit var date: Date

    @Column(name = "latitude")
    var latitude: Double = 0.0

    @Column(name = "longitude")
    var longitude: Double = 0.0

    @Column(name = "altitude")
    var altitude: Double = 0.0

    @Column(name = "accuracy")
    var accuracy: Double = 0.0

    constructor() {
    }

    constructor(configuration: Configuration, date: Date, latitude: Double, longitude: Double, altitude: Double, accuracy: Double) {
        this.configuration = configuration
        this.date = date
        this.latitude = latitude
        this.longitude = longitude
        this.altitude = altitude
        this.accuracy = accuracy
    }

}