package za.ac.iie.practicumexamimad5112st10479817

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val arraySongs = Array(10){""}
    private val arrayArtists = Array(4){""}
    private val arrayRatings = IntArray(4)
    private val arrayComments = Array(4){""}

    private var count = 1


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
            var text1 = ""

            val ratingScore = edtRatings.toInt()

            for (count)



            for (i in arraySongs.indices){




                val songTitles = edtSongTitles.text.trim()
                val artistNames = edtArtistNames.text.trim()
                val userComments = edtUserComments.text.trim()









            if (songTitles != null || artistNames != null || userComments != null){
                arraySongs[i] = songTitles.toString()
                arrayArtists[i] = artistNames.toString()
                arrayComments[i] = userComments.toString()



                text1 += "${arraySongs[i]} \n"


            } else{
                if (songTitles == null && artistNames == null && userComments == null ){
                    text.text = "Nothing"
                }
            }
            }
            text.text = text1



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