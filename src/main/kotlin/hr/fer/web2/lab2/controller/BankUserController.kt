package hr.fer.web2.lab2.controller

import hr.fer.web2.lab2.model.dao.toBankUserDTO
import hr.fer.web2.lab2.model.dto.BankUserDTO
import hr.fer.web2.lab2.service.BankUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user", produces = ["application/json"])
class BankUserController(
    private val bankUserService: BankUserService,
) {

    @GetMapping
    @CrossOrigin(origins = ["http://localhost:3000", "https://vulnerable-application-fe.vercel.app"])
    fun getUser(
        @RequestParam(required = false, defaultValue = "false") vulnerable: Boolean
    ): ResponseEntity<Any> {
        // we want to keep sensitive data hidden from the client as much as possible
        return if(vulnerable) {
            ResponseEntity.ok(bankUserService.getAllBankUsers()[0])
        } else {
            ResponseEntity.ok(bankUserService.getAllBankUsers()[0].toBankUserDTO())
        }
    }

}