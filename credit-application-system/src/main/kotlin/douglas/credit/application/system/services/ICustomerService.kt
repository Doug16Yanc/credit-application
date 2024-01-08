package douglas.credit.application.system.services

import douglas.credit.application.system.entities.Customer

interface ICustomerService {
    fun saveCustomer(customer : Customer) : Customer

    fun findById(id : Long) : Customer

    fun deleteCustomer(id : Long)
}