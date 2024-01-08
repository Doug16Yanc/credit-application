package douglas.credit.application.system.entities

import douglas.credit.application.system.enumerations.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class Credit(
    val creditcode : UUID = UUID.randomUUID(),
    val creditvalue : BigDecimal,
    val dayFirstInstallment : LocalDate,
    val numberOfInstallments : Int,
    val status : Status = Status.IN_PROGRESS,
    val customer : Customer? = null,
    val id : Long? = null
)
