package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewLoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cancelButton: Button
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_login)

        email = findViewById(R.id.login_email)
        password = findViewById(R.id.login_password)
        cancelButton = findViewById(R.id.login_cancel)
        validateButton = findViewById(R.id.login_validate)

        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        validateButton.setOnClickListener {

            // check empty fields & e-mail format
            if (isFieldEmpty(email, this) or
                isFieldEmpty(password, this) or
                !isEmailValid(email.text?.toString(), this)) {
                return@setOnClickListener
            }

            // transmet la paire e-mail/mdp
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(RESULT_MSG, Pair(email.text.toString(), password.text.toString()))
            })
            finish()
        }
    }

    companion object {
        const val RESULT_MSG = "NewLogin.RES"
    }
}