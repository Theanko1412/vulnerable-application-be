package hr.fer.web2.lab2.controller

import hr.fer.web2.lab2.model.dao.GoogleSearchDAO
import hr.fer.web2.lab2.service.GoogleSearchService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/google", produces = ["application/json"])
@CrossOrigin(origins = ["http://localhost:3000", "https://vulnerable-application.commanderkowalski.uk", "https://vulnerable-application-fe.vercel.app"])
class GoogleSearchController(
    private val googleSearchService: GoogleSearchService,
) {

    @GetMapping
    fun getGoogleSearches(
        @RequestParam(required = false, defaultValue = "false") vulnerable: Boolean
    ) : List<GoogleSearchDAO> {
        return googleSearchService.getAllGoogleSearches(vulnerable)
    }

    @PostMapping
    fun addGoogleSearch(
        @RequestBody search: String,
        @RequestParam(required = false, defaultValue = "false") vulnerable: Boolean
    ) : GoogleSearchDAO {
        return googleSearchService.addGoogleSearch(vulnerable, GoogleSearchDAO(searchText = search))
    }
}