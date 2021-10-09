package ch.heigvd.iict.sym.labo1

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast

private const val TAG: String = "LoginHelper"

fun isFieldEmpty(fieldInput: EditText, context: Context): Boolean {
    //on réinitialise les messages d'erreur
    fieldInput.error = null
    return if (fieldInput.text?.toString().isNullOrEmpty()) {
        // on affiche un message dans les logs de l'application
        Log.d(TAG, "Au moins un des deux champs est vide")
        // on affiche un message d'erreur sur les champs qui n'ont pas été renseignés
        // la méthode getString permet de charger un String depuis les ressources de
        // l'application à partir de son id
        fieldInput.error = context.getString(R.string.main_mandatory_field)
        true
    } else {
        false
    }
}

fun isEmailValid(email: String?, context: Context): Boolean {
    return if (Patterns.EMAIL_ADDRESS.matcher(email as CharSequence).matches()) {
        true
    } else {
        // afficher un message temporaire pour indiquer l'erreur
        Toast.makeText(
            context.applicationContext,
            context.getString(R.string.main_email_invalid),
            Toast.LENGTH_SHORT
        ).show()
        false
    }
}
