package douglas.credit.application.system.dto.clients

import douglas.credit.application.system.entities.Customer
import java.math.BigDecimal

class CustomerView(
    val firstName : String,
    val lastName : String,
    val cpf : String,
    val income : BigDecimal,
    val email : String,
    val zipcode : String,
    val street : String
) {
    constructor(customer : Customer) : this (
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipcode = customer.address.zipcode,
        street = customer.address.street
    )
}
