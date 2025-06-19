package za.ac.iie.practicumexamimad5112st10479817

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        val Songs = intent.getStringArrayExtra("Songs" )
        val Artists = intent.getStringArrayExtra("Artists" )
        val Comments = intent.getStringArrayExtra("Comments")
        val Ratings = intent.getIntArrayExtra("Ratings")

        val txtSong = findViewById<TextView>(R.id.txtSongs)
        val txtArtist = findViewById<TextView>(R.id.txtArtist)
        val txtRating = findViewById<TextView>(R.id.txtRating)
        val txtComment = findViewById<TextView>(R.id.txtComment)

        val txtSongBuilder = StringBuilder()
        val txtArtistBuilder = StringBuilder()
        val txtRatingBuilder = StringBuilder()
        val txtCommentBuilder = StringBuilder()

        if (Songs != null && Comments != null && Artists != null && Ratings != null) {
            for (i in Songs.indices) {
                if (Songs[i].isNotBlank()) {

                    txtSongBuilder.append("${Songs[i]}\n")
                    txtArtistBuilder.append("${Artists[i]}\n")
                    txtRatingBuilder.append("${Ratings[i]}\n")
                    txtCommentBuilder.append("${Comments[i]}\n")


                }
            }
        }

        txtSong.text = txtSongBuilder.toString()
        txtArtist.text = txtArtistBuilder.toString()
        txtRating.text = txtRatingBuilder.toString()
        txtComment.text = txtCommentBuilder.toString()




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}