package douglas.credit.application.system.dto.credits

import douglas.credit.application.system.entities.Credit
import douglas.credit.application.system.enumerations.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditcode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomeCustomer: BigDecimal
) {
    constructor(credit: Credit) : this(
        creditcode = credit.creditcode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomeCustomer = credit.customer?.income ?: BigDecimal.ZERO
    )
}

