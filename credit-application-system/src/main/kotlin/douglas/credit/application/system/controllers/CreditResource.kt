package douglas.credit.application.system.controllers

import douglas.credit.application.system.dto.credits.CreditDTO
import douglas.credit.application.system.dto.credits.CreditView
import douglas.credit.application.system.dto.credits.CreditViewList
import douglas.credit.application.system.entities.Credit
import douglas.credit.application.system.services.classes.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto : CreditDTO) : ResponseEntity<String> {
        val creditSaved : Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(
        "Credit ${creditSaved.creditcode} - Customer ${creditSaved.customer?.firstName} saved successfully!\n")
    }
    @GetMapping
    fun findByAllCustomerId(@RequestParam(value = "customerId") customerId : Long) : ResponseEntity<List<CreditViewList>> {
        val creditViewLists : List<CreditViewList> = this.creditService.findAllByCustomer(customerId).stream().map{credit : Credit ->
            CreditViewList(credit)}.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewLists)
    }
    @GetMapping("/{creditcode}")
    fun findByCreditCode(@RequestParam(value = "customerId") customerId: Long,
                         @PathVariable creditCode : UUID
    ) : ResponseEntity<CreditView> {
        val credit : Credit = this.creditService.findByCreditCode(customerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }

}