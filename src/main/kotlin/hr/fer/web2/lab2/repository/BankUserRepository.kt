package hr.fer.web2.lab2.repository

import hr.fer.web2.lab2.model.dao.BankUserDAO
import hr.fer.web2.lab2.model.dto.BankUserDTO
import org.springframework.data.jpa.repository.JpaRepository

interface BankUserRepository : JpaRepository<BankUserDAO, String> {

    fun findBankUserDAOById(id: String): BankUserDAO?
}