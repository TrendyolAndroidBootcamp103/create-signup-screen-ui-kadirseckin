package school.cactus.succulentshop.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validators.SignUpValidator
import school.cactus.succulentshop.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val signUpValidator =
        SignUpValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            //Validate
            signupButton.setOnClickListener {
                signupEmailInputLayout.validate()
                signupPasswordInputLayout.validate()
                signupUsernameInputLayout.validate()
            }

            //Navigate
            createAccountButton.setOnClickListener {
                navigateToLoginActivity()
            }

        }
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun TextInputLayout.validator(value: String) = when (this) {
        binding.signupEmailInputLayout -> signUpValidator.validateEmail(value)
        binding.signupUsernameInputLayout -> signUpValidator.validateUserName(value)
        binding.signupPasswordInputLayout -> signUpValidator.validatePassword(value)
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }

    private fun Int.resolveAsString() = getString(this)

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


}