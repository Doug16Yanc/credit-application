package douglas.credit.application.system.dto.clients

import douglas.credit.application.system.entities.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDTO(
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val firstName : String,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val lastName : String,
    @field:NotNull(message = "Sorry, but this input can´t be null.")
    var income : BigDecimal,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val zipcode : String,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val street : String
)
{
    fun toEntity(customer : Customer) : Customer {
        customer.firstName = this.firstName
        customer.lastName  = this.lastName
        customer.income = this.income
        customer.address.zipcode = this.zipcode
        customer.address.street = this.street
        return customer
    }
}
