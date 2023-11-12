package hr.fer.web2.lab2.service

import hr.fer.web2.lab2.repository.BankUserRepository
import org.springframework.stereotype.Service

@Service
class BankUserService(private val bankUserRepository: BankUserRepository) {

    fun getAllBankUsers() = bankUserRepository.findAll()

    fun getBankUserById(id: String) = bankUserRepository.findBankUserDAOById(id)
}