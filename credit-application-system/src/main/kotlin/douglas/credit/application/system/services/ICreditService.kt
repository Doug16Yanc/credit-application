package douglas.credit.application.system.services

import douglas.credit.application.system.entities.Credit
import java.util.*

interface ICreditService {
    fun saveCredit(credit : Credit) : Credit

    fun findAllByCustomer(customer : Long) : List<Credit>

    fun findByCreditCode(customerId : Long, creditcode : UUID) : Credit?
}