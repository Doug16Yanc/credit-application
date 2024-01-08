package douglas.credit.application.system.dto.clients

import douglas.credit.application.system.entities.Customer
import java.math.BigDecimal

data class CustomerUpdateDTO(
    val firstName : String,
    val lastName : String,
    var income : BigDecimal,
    val zipcode : String,
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
