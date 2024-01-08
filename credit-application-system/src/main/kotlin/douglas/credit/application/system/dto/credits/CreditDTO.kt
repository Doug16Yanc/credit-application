package douglas.credit.application.system.dto.credits

import douglas.credit.application.system.entities.Credit
import douglas.credit.application.system.entities.Customer
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditDTO(
    val creditValue : BigDecimal,
    val dayFirstOfInstallment : LocalDate,
    val numberOfInstallments : Int,
    val customerId : Long
    ){
    fun toEntity() : Credit = Credit(
        creditValue = this.creditValue,
        dayFirstOfInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(
            id = this.customerId
        )
    )

}
