package hr.fer.web2.lab2.model.dto


// putting only the fields we want to expose to the client, keeping it as concise as possible
// we will obfuscate needed fields for GPDR compliance
// if some sensitive data need to be transferred, we can encrypt it and decrypt it on the client side
// (did not implement any encryption)
data class BankUserDTO(
    val id: String? = null,
    val username: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val country: String? = null,
)

fun obfuscate(input: String?): String? {
    return input?.let {
        "****" + it.takeLast(4)
    }
}
