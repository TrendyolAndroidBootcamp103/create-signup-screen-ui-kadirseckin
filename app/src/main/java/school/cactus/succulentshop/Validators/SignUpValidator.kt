package school.cactus.succulentshop.Validators

import school.cactus.succulentshop.R

class SignUpValidator {

    //Validate methods
    fun validateEmail(field: String): Int? = when {
        field.isEmpty() -> R.string.emailRequired
        !field.emailCharacterControl() -> R.string.invalidEmail
        field.length <= 5 -> R.string.invalidEmail
        field.length >= 50 -> R.string.invalidEmail
        else -> null
    }

    fun validatePassword(field: String): Int? = when {
        field.isEmpty() -> R.string.passwordRequired
        field.length <= 7 -> R.string.shortPassword
        field.length >= 40 -> R.string.longPassword
        !field.passwordCharacterControl() -> R.string.badPasswordFormat
        else -> null
    }


    fun validateUserName(field: String): Int? = when {
        field.isEmpty() -> R.string.userNameRequired
        !field.userNameCharacterControl() -> R.string.badUserNameFormat
        field.length <= 2 -> R.string.shortUserName
        field.length >= 20 -> R.string.longUserName
        else -> null
    }


    //Extension methods
    private fun String.isContainsLowerCase() = any { it.isLowerCase() }
    private fun String.isContainsUpperCase() = any { it.isUpperCase() }
    private fun String.isContainsDigit() = any { it.isDigit() }
    private fun String.isContainsSpecialCharacter() = any { !it.isLetterOrDigit() }
    private fun String.emailCharacterControl() = any { it == '@' } && any { it == '.' }
    private fun String.userNameCharacterControl() = all { it.isLetterOrDigit() || it == '_' }
    private fun String.passwordCharacterControl() =
            isContainsLowerCase() && isContainsUpperCase() && isContainsSpecialCharacter() && isContainsDigit()


}