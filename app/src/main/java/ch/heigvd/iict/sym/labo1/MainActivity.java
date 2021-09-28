package ch.heigvd.iict.sym.labo1;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // on définit une liste de couples e-mail / mot de passe
    // ceci est fait juste pour simplifier ce premier laboratoire,
    // mais il est évident que de hardcoder ceux-ci est une pratique à éviter à tout prix...
    private List<Pair<String, String>> credentials = new ArrayList<>(Arrays.asList(
            new Pair<>("user1@heig-vd.ch", "1234"),
            new Pair<>("user2@heig-vd.ch", "abcd")));

    private EditText email;
    private EditText password;
    private Button cancelButton;
    private Button validateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // l'appel à la méthode onCreate de la super classe est obligatoire
        super.onCreate(savedInstanceState);
        // on définit le layout à utiliser pour l'affichage
        setContentView(R.layout.activity_main);

        // on va maintenant lier le code avec les éléments graphiques (champs texts, boutons, etc.)
        // présents dans le layout (nous allons utiliser l'id défini dans le layout, le cast est
        // réalisé automatiquement)
        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);
        cancelButton = findViewById(R.id.main_cancel);
        validateButton = findViewById(R.id.main_validate);

        //mise en place des événements
        cancelButton.setOnClickListener(view -> {
            //on va vider les champs de la page de login lors du clique sur le bouton Cancel
            email.getText().clear();
            password.getText().clear();
            // on annule les éventuels messages d'erreur présents sur les champs de saisie
            email.setError(null);
            password.setError(null);
        });

        validateButton.setOnClickListener(view -> {
            //on réinitialise les messages d'erreur
            email.setError(null);
            password.setError(null);

            //on récupère le contenu de deux champs dans des variables de type String
            String emailInput = email.getText().toString();
            String passwordInput = password.getText().toString();

            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                // on affiche un message dans les logs de l'application
                Log.d(TAG, "Au moins un des deux champs est vide");
                // on affiche un message d'erreur sur les champs qui n'ont pas été renseignés
                // la méthode getString permet de charger un String depuis les ressources de
                // l'application à partir de son id
                if (emailInput.isEmpty())
                    email.setError(getString(R.string.main_mandatory_field));
                if (passwordInput.isEmpty())
                    password.setError(getString(R.string.main_mandatory_field));

                return;
            }

            //TODO à compléter...

            if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                Toast.makeText(this,
                        getString(R.string.main_toast_email_error),
                        Toast.LENGTH_SHORT).show();
            } else if (!credentials.contains(new Pair<>(emailInput, passwordInput))) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.main_error).setTitle(R.string.main_error_credentials);
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                
            }
        });

    }
}
