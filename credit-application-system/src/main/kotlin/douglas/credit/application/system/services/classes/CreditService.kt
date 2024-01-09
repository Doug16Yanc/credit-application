package douglas.credit.application.system.services.classes

import douglas.credit.application.system.entities.Credit
import douglas.credit.application.system.repositories.CreditRepository
import douglas.credit.application.system.services.interfaces.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
    ) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply { customer = customerService.findById(credit.customer?.id!!) }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditcode: UUID): Credit {
    val credit: Credit = (
            this.creditRepository.findByCreditCode(creditcode)
                ?: throw RuntimeException("Credit code $creditcode not found.\n"))
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin, please!\n")
    }
}