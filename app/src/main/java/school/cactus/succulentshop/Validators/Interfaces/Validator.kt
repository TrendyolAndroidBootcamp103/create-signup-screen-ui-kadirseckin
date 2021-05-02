package school.cactus.succulentshop.Validators.Interfaces

interface Validator {
    fun validate(field: String): Int?
}