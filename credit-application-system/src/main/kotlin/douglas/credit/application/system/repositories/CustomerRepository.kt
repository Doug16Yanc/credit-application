package douglas.credit.application.system.repositories

import douglas.credit.application.system.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}