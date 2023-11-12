package hr.fer.web2.lab2.model.dao

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data

@Entity
@Data
@Table(name = "google_search")
class GoogleSearchDAO (
    @get:Id
    @get:GeneratedValue
    open var id: Int? = null,
    open var searchText: String? = null,
)