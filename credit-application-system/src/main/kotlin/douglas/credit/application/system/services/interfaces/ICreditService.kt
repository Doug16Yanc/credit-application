package douglas.credit.application.system.services.interfaces

import douglas.credit.application.system.entities.Credit
import java.util.*

interface ICreditService {
    fun save(credit : Credit) : Credit

    fun findAllByCustomer(customer : Long) : List<Credit>

    fun findByCreditCode(customerId : Long, creditcode : UUID) : Credit?
}