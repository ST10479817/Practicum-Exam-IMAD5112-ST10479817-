package za.ac.iie.practicumexamimad5112st10479817

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val arraySongs = Array(4){""}
    private val arrayArtists = Array(4){""}
    private val arrayRatings = IntArray(4)
    private val arrayComments = Array(4){""}

    private var count = 0


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


        val text = findViewById<TextView>(R.id.text02)

        btnAddingToPlaylist.setOnClickListener {





                val songTitles = edtSongTitles.toString().trim()
                val artistNames = edtArtistNames.toString().trim()
                val userComments = edtUserComments.toString().trim()
                val ratingNumber = edtRatings.toString().trim()

                val ratingScore = ratingNumber.toIntOrNull()



            if (count < arraySongs.size && artistNames.isNotEmpty() && userComments.isNotEmpty() && ratingNumber != null && ratingScore in 1..5 && songTitles.isNotEmpty()){
                arraySongs[count] = songTitles
                arrayArtists[count] = artistNames
                arrayComments[count] = userComments
                arrayRatings[count] = ratingNumber.toIntOrNull() ?:0

                count++

                text.text = ""

            } else{
                    text.text = "Please full in all the options"
                }


        }

        btnNextScreen.setOnClickListener {

            val intent = Intent(this, DetailedView ::class.java)

            intent.putExtra("Song", arraySongs)
            intent.putExtra("Artists", arrayArtists)
            intent.putExtra("Comments", arrayComments)
            intent.putExtra("Ratings", arrayRatings)
            startActivity(intent)
            finish()

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