package douglas.credit.application.system.repositories

import douglas.credit.application.system.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository : JpaRepository<Credit, Long> {
    fun findByCreditCode(creditcode : UUID) : Credit?
    fun findAllByCustomerId(customerId : Long): List<Credit>
}