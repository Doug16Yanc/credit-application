package douglas.credit.application.system.controllers

import douglas.credit.application.system.dto.clients.CustomerDTO
import douglas.credit.application.system.dto.clients.CustomerUpdateDTO
import douglas.credit.application.system.dto.clients.CustomerView
import douglas.credit.application.system.entities.Customer
import douglas.credit.application.system.services.classes.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/resources")
class CustomerResource(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDTO : CustomerDTO) : ResponseEntity<String> {
        val savedCustomer = this.customerService.saveCustomer(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved.\n")
    }
    @GetMapping("/{id}")
    fun findById(@PathVariable Id: Long) : ResponseEntity<CustomerView> {
        val customer : Customer = this.customerService.findById(Id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable Id : Long){
        this.customerService.deleteCustomer(Id)
    }
    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id : Long, @RequestBody @Valid customerUpdateDto : CustomerUpdateDTO) : ResponseEntity<CustomerView> {
        val customer = this.customerService.findById(id)
        val customerToUpdate : Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated = this.customerService.saveCustomer(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }
}