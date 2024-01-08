package douglas.credit.application.system.controllers

import douglas.credit.application.system.dto.clients.CustomerDTO
import douglas.credit.application.system.dto.clients.CustomerUpdateDTO
import douglas.credit.application.system.dto.clients.CustomerView
import douglas.credit.application.system.entities.Customer
import douglas.credit.application.system.services.classes.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/resources")
class CustomerResource(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDTO : CustomerDTO) : String {
        val savedCustomer = this.customerService.saveCustomer(customerDTO.toEntity())
        return "Customer ${savedCustomer.email} saved.\n"
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable Id: Long) : CustomerView {
        val customer : Customer = this.customerService.findById(Id)
        return CustomerView(customer)
    }
    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable Id : Long){
        this.customerService.deleteCustomer(Id)
    }
    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id : Long, @RequestBody customerUpdateDto : CustomerUpdateDTO) : CustomerView {
        val customer = this.customerService.findById(id)
        val customerToUpdate : Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated = this.customerService.saveCustomer(customerToUpdate)
        return CustomerView(customerUpdated)
    }
}