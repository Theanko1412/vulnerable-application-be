package hr.fer.web2.lab2.service

import hr.fer.web2.lab2.model.dao.GoogleSearchDAO
import hr.fer.web2.lab2.repository.GoogleSearchRepository
import org.springframework.stereotype.Service

@Service

class GoogleSearchService(private val googleSearchRepository: GoogleSearchRepository) {

    fun getAllGoogleSearches(vulnerable: Boolean): List<GoogleSearchDAO> {
        return googleSearchRepository.findAll().filter{
            if(vulnerable) {
                true
            } else {
                it.searchText?.matches(Regex("^[a-zA-Z0-9]+$")) == true
            }
        }
    }

    fun addGoogleSearch(vulnerable: Boolean, searchDAO: GoogleSearchDAO): GoogleSearchDAO {
        if (!vulnerable) {
            val regex = Regex("^[a-zA-Z0-9]+$")
            require(searchDAO.searchText?.matches(regex) == true) { "Invalid search text" }
        }
        return googleSearchRepository.save(searchDAO)
    }

}