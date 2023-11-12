package hr.fer.web2.lab2.model.dao

import hr.fer.web2.lab2.model.dto.BankUserDTO
import hr.fer.web2.lab2.model.dto.obfuscate
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data

@Entity
@Data
@Table(name = "bank_user")
class BankUserDAO(

    @get:Id
    @get:GeneratedValue // we would use (strategy = GenerationType.UUID) so attacker can't guess the next id
    open var id: String? = null,
    open var username: String? = null,
    open var password: String? = null,
    open var firstName: String? = null,
    open var lastName: String? = null,
    open var email: String? = null,
    open var phoneNumber: String? = null,
    open var address: String? = null,
    open var city: String? = null,
    open var country: String? = null,
    open var postalCode: String? = null,
    open var oib: String? = null,
    open var iban: String? = null,
    open var accountNumber: String? = null,
    open var balance: Double? = null,
    open var currency: String? = null,
    open var role: String? = null,
    open var enabled: Boolean? = null,
    open var token: String? = null,
    open var tokenExpirationDate: String? = null,
    open var lastLoginDate: String? = null,
    open var lastLoginIp: String? = null,
    open var lastLoginLocation: String? = null,
    open var lastLoginBrowser: String? = null,
    open var lastLoginOs: String? = null,
    open var lastLoginDevice: String? = null,
    open var lastLoginDeviceType: String? = null,
    open var lastLoginDeviceBrand: String? = null,
    open var lastLoginDeviceModel: String? = null,
    open var lastLoginDeviceBrowser: String? = null,
    open var lastLoginDeviceOs: String? = null,
    open var lastLoginDeviceOsVersion: String? = null,
    open var lastLoginDeviceBrowserVersion: String? = null
)

fun BankUserDAO.toBankUserDTO(): BankUserDTO {
    return BankUserDTO(
        id = obfuscate(this.id),
        username = obfuscate(this.username),
        firstName = this.firstName,
        lastName = obfuscate(this.lastName),
        email = obfuscate(this.email),
        country = this.country,
    )
}
