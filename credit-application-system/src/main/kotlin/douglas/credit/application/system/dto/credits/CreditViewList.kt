package douglas.credit.application.system.dto.credits

import douglas.credit.application.system.entities.Credit
import java.math.BigDecimal
import java.util.*

data class CreditViewList(
    val creditcode : UUID,
    val creditValue : BigDecimal,
    val numberOfInstallments : Int,

    ) {
    constructor(credit: Credit) : this(
        creditcode = credit.creditcode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments
    )
}