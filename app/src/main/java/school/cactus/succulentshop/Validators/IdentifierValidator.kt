package school.cactus.succulentshop.Validators

import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validators.Interfaces.Validator


class IdentifierValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        field.length < 5 -> R.string.identifier_is_too_short
        else -> null
    }

}