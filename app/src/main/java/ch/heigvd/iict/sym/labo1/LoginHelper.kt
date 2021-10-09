package ch.heigvd.iict.sym.labo1

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast

/**
 * Fichier utilitaire regroupant des fonctions pour la vérifcation de login
 * @author Alessandro Parrino, Daniel Sciarra, Gaétan Zwick
 * @sdk 29
 * @date 10.10.21
 */

private const val TAG: String = "LoginHelper"

/**
 * Determine si le champ passé en paramètre est vide
 * @param fieldInput champ à vérifier
 * @param context Context d'exécution
 * @return true si le champ est vide, sinon false
 */
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

/**
 * Determine si l'e-mail passé en paramètre est valide au niveau du format
 * @param email e-mail à vérifier
 * @param context Context d'exécution
 * @return true si l'e-mail est valide, sinon false
 */
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
