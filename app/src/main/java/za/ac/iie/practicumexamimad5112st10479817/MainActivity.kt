package za.ac.iie.practicumexamimad5112st10479817

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtSongTitles = findViewById<EditText>(R.id.edtSongName)
        val edtArtistNames = findViewById<EditText>(R.id.edtArtistName)
        val edtRatings = findViewById<EditText>(R.id.edtRatingNumber)
        val edtUserComments = findViewById<EditText>(R.id.edtUserComment)
        val btnAddingToPlaylist =findViewById<Button>(R.id.btnAddToPlaylist)
        val btnNextScreen = findViewById<Button>(R.id.btnDeailedScreen)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAddingToPlaylist.setOnClickListener {

        }

        btnNextScreen.setOnClickListener {

        }

        btnExit.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}