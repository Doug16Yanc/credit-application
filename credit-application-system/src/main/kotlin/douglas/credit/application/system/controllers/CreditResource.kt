package douglas.credit.application.system.controllers

import douglas.credit.application.system.dto.credits.CreditDTO
import douglas.credit.application.system.entities.Credit
import douglas.credit.application.system.services.classes.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditDto : CreditDTO) : String {
        val creditSaved : Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${creditSaved.creditcode} - Customer ${creditSaved.customer?.firstName} saved successfully!\n"
    }
}