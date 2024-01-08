package douglas.credit.application.system.repositories

import douglas.credit.application.system.entities.Credit
import org.springframework.data.jpa.repository.JpaRepository

interface CreditRepository : JpaRepository<Credit, Long> {

}