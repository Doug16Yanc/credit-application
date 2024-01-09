package douglas.credit.application.system.dto.clients

import douglas.credit.application.system.entities.Address
import douglas.credit.application.system.entities.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val firstName : String,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val lastName : String,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    @CPF(message = "Invalid CPF.")
    val cpf : String,
    @field:NotNull(message = "Sorry, but this input can´t be empty.")
    val income : BigDecimal,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    @field:Email(message = "Invalid email.\n")
    val email : String,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val password : String,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
    val zipcode : String,
    @field:NotEmpty(message = "Sorry, but this input can´t be empty.")
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
