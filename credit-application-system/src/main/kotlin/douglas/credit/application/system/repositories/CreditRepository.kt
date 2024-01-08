package douglas.credit.application.system.repositories

import douglas.credit.application.system.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository : JpaRepository<Credit, Long> {
    @Query("SELECT c FROM Credit c WHERE c.creditcode = :creditCode")
    fun findByCreditCode(@Param("creditCode") creditCode: UUID): Credit
    /*@Query(value = "SELECT * FROM credit WHERE customer_id = ?1", nativeQuery = true)*/
    fun findAllByCustomerId(customerId : Long): List<Credit>
}