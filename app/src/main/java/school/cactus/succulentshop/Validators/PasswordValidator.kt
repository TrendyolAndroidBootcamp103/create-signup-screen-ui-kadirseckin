package school.cactus.succulentshop.Validators

import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validators.Interfaces.Validator

class PasswordValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        else -> null
    }
}