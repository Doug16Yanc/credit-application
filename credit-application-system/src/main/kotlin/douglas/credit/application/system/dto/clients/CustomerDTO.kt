package douglas.credit.application.system.dto.clients

import douglas.credit.application.system.entities.Address
import douglas.credit.application.system.entities.Customer
import java.math.BigDecimal

data class CustomerDTO(
    val firstName : String,
    val lastName : String,
    val cpf : String,
    val income : BigDecimal,
    val email : String,
    val password : String,
    val zipcode : String,
    val street : String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipcode = this.zipcode,
            street = this.street
        )
    )
}
