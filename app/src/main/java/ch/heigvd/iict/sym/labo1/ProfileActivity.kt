package ch.heigvd.iict.sym.labo1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ch.heigvd.iict.sym.labo1.MainActivity.Companion.EXTRA_MSG
import ch.heigvd.iict.sym.labo1.network.ImageDownloader

/**
 * Activitée représentant le profile de l'utilisateur loggé
 * @author Alessandro Parrino, Daniel Sciarra, Gaétan Zwick
 * @sdk 29
 * @date 10.10.21
 */
class ProfileActivity : LifeCycleAppCompatActivity() {

    private lateinit var email: TextView
    private lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        email = findViewById(R.id.profile_email)
        img = findViewById(R.id.profile_photo)

        ImageDownloader(img, "https://thispersondoesnotexist.com/image").show()
        email.text = getString(R.string.profile_email, intent.getStringExtra(EXTRA_MSG))

    }
}