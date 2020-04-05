package pl.lodz.p.edu.dliwocha.geofence.api.entity

import javax.persistence.*

@Entity
@Table(name = "configuration_t")
class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    @Column(name = "external_id", unique = true)
    lateinit var externalId: String

    @Column(name = "tracked_object_id", unique = true)
    lateinit var trackedObjectId: String

    @Column(name = "name")
    lateinit var name: String

    @Column(name = "position_interval")
    var positionInterval: Int = 1

    constructor() {
    }

    constructor(externalId: String, trackedObjectId: String, name: String, positionInterval: Int) {
        this.externalId = externalId
        this.trackedObjectId = trackedObjectId
        this.name = name
        this.positionInterval = positionInterval
    }

}