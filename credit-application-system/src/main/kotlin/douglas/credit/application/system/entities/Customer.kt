package douglas.credit.application.system.entities

data class Customer(
    val id : Long,
    var firstName : String,
    var lastName : String,
    val cpf : String,
    var email : String,
    var password : String,
    var address : Address,
    var credits : List<Credit> = mutableListOf()
)
