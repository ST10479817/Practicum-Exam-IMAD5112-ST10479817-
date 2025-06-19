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





                val songTitles = edtSongTitles.text.toString().trim()
                val artistNames = edtArtistNames.text.toString().trim()
                val userComments = edtUserComments.text.toString().trim()
                val ratingNumber = edtRatings.text.toString().trim()

                val ratingScore = ratingNumber.toIntOrNull()



            if (count in 0..4 && songTitles.isNotEmpty() && artistNames.isNotEmpty() && userComments.isNotEmpty() && ratingScore != null && ratingScore in 1..5 && songTitles.isNotEmpty()){
                arraySongs[count] = songTitles
                arrayArtists[count] = artistNames
                arrayComments[count] = userComments
                arrayRatings[count] = ratingScore

                count++

                text.text = "You have added ${count} out of 4"

                edtSongTitles.text.clear()
                edtArtistNames.text.clear()
                edtUserComments.text.clear()
                edtRatings.text.clear()

            } else {
                    text.text = "Please full in all the options or please insure that your rating is between 1 and 5."
                }

            if (count == 0){
                text.text = "Please enter in one song"
                return@setOnClickListener
            }
            if (count == 4){
                text.text = "All 4 songs has been added."
                btnAddingToPlaylist.visibility = Button.GONE


                return@setOnClickListener
            }


        }

        btnNextScreen.setOnClickListener {

            val intent = Intent(this, DetailedView ::class.java)

            intent.putExtra("Songs", arraySongs)
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