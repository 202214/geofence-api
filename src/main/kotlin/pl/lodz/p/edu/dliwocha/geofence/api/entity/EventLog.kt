package pl.lodz.p.edu.dliwocha.geofence.api.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "event_log_t")
data class EventLog(

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

        @Column(name = "content", columnDefinition = "varchar(4000)")
        val content: String

)