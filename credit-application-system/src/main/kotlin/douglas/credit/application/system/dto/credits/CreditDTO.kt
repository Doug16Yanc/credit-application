package douglas.credit.application.system.dto.credits

import douglas.credit.application.system.entities.Credit
import douglas.credit.application.system.entities.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditDTO(
    @field:NotNull(message = "Sorry, but this input can´t be null.")
    val creditValue : BigDecimal,
    @field:Future
    val dayFirstOfInstallment : LocalDate,
    val numberOfInstallments : Int,
    @field:NotNull(message = "Sorry, but this input can´t be null.\n")
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
