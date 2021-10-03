package ch.heigvd.iict.sym.labo1

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.sym.labo1.NewLoginActivity.Companion.RESULT_MSG

class MainActivity : AppCompatActivity() {

    // on définit une liste de couples e-mail / mot de passe
    // ceci est fait juste pour simplifier ce premier laboratoire,
    // mais il est évident que de hardcoder ceux-ci est une pratique à éviter à tout prix...
    // /!\ listOf() retourne une List<T> qui est immuable
    private var credentials = mutableListOf(
        Pair("user1@heig-vd.ch", "1234"),
        Pair("user2@heig-vd.ch", "abcd")
    )

    // le modifieur lateinit permet de définir des variables avec un type non-null
    // sans pour autant les initialiser immédiatement
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cancelButton: Button
    private lateinit var validateButton: Button
    private lateinit var newAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        // l'appel à la méthode onCreate de la super classe est obligatoire
        super.onCreate(savedInstanceState)
        // on définit le layout à utiliser pour l'affichage
        setContentView(R.layout.activity_main)

        // on va maintenant lier le code avec les éléments graphiques (champs texts, boutons, etc.)
        // présents dans le layout (nous allons utiliser l'id défini dans le layout, le cast est
        // réalisé automatiquement)
        email = findViewById(R.id.main_email)
        password = findViewById(R.id.main_password)
        cancelButton = findViewById(R.id.main_cancel)
        validateButton = findViewById(R.id.main_validate)
        newAccount = findViewById(R.id.main_new_account)
        // Kotlin, au travers des Android Kotlin Extensions permet d'automatiser encore plus cette
        // étape en créant automatiquement les variables pour tous les éléments graphiques présents
        // dans le layout et disposant d'un id
        // cf. https://medium.com/@temidjoy/findviewbyid-vs-android-kotlin-extensions-7db3c6cc1d0a

        //mise en place des événements
        cancelButton.setOnClickListener {
            //on va vider les champs de la page de login lors du clique sur le bouton Cancel
            email.text?.clear()
            password.text?.clear()
            // on annule les éventuels messages d'erreur présents sur les champs de saisie
            email.error = null
            password.error = null
        }

        validateButton.setOnClickListener {

            //on récupère le contenu de deux champs dans des variables de type String
            val emailInput = email.text?.toString()
            val passwordInput = password.text?.toString()

            // check empty fields & e-mail format
            if (isFieldEmpty(email, this) or
                isFieldEmpty(password, this) or
                !isEmailValid(emailInput, this)) {
                // Pour les fonctions lambda, on doit préciser à quelle fonction l'appel à return
                // doit être appliqué
                return@setOnClickListener
            }

            // check email-password couple
            if (!credentials.contains(Pair(emailInput, passwordInput))) {
                val alertDialog: AlertDialog = this.let {
                    val builder = AlertDialog.Builder(it)
                    builder.setTitle(R.string.main_invalid_credentials)
                    builder.apply {
                        setNeutralButton(
                            R.string.main_credentails_dialog_btn,
                            DialogInterface.OnClickListener { _, _ -> })
                    }
                    builder.create()
                }
                alertDialog.show()
                return@setOnClickListener
            } else {
                // lancement de la nouvelle activité
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra(EXTRA_MSG, emailInput)
                }
                // .apply fait la même chose que la ligne suivante :
                // intent.putExtra(EXTRA_MSG, emailInput)
                startActivity(intent)
            }
        }

        newAccount.setOnClickListener {
            getContent.launch(Intent(this, NewLoginActivity::class.java))
        }
    }

    // récupère et ajoute les credentials d'inscription
    private val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val extra = result.data!!.extras
                val newCred = extra?.get(RESULT_MSG) as Pair<String, String>
                credentials.add(newCred)
            }
        }

    // En Kotlin, les variables static ne sont pas tout à fait comme en Java
    // pour des raison de lisibilité du code, les variables et méthodes static
    // d'une classe doivent être regroupées dans un bloc à part: le companion object
    // cela permet d'avoir un aperçu plus rapide de tous les éléments static d'une classe
    // sans devoir trouver le modifieur dans la définition de ceux-ci, qui peuvent être mélangé
    // avec les autres éléments non-static de la classe
    companion object {
        const val EXTRA_MSG = "com.labo1.EMAIL"
    }

}
