package douglas.credit.application.system.entities

import douglas.credit.application.system.enumerations.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Credit")
data class Credit(
    @Column(nullable = false, unique = true)
    val creditcode : UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val creditvalue : BigDecimal,
    @Column(nullable = false)
    val dayFirstInstallment : LocalDate,
    @Column(nullable = false, unique = true)
    val numberOfInstallments : Int,
    @Enumerated
    val status : Status = Status.IN_PROGRESS,
    @ManyToOne
    var customer : Customer? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
)
