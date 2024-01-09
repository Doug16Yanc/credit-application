package douglas.credit.application.system.services.classes

import douglas.credit.application.system.entities.Customer
import douglas.credit.application.system.repositories.CustomerRepository
import douglas.credit.application.system.services.interfaces.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun saveCustomer(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not found in this database")
        }

    override fun deleteCustomer(id: Long){
        val customer : Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}