package hr.fer.web2.lab2.repository

import hr.fer.web2.lab2.model.dao.GoogleSearchDAO
import org.springframework.data.jpa.repository.JpaRepository

interface GoogleSearchRepository : JpaRepository<GoogleSearchDAO, String> {

    fun findGoogleSearchDAOById(id: Int): GoogleSearchDAO?

}