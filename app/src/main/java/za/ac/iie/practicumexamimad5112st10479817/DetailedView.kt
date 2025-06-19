package za.ac.iie.practicumexamimad5112st10479817

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
        val txtAvgRating = findViewById<TextView>(R.id.AvgRating)

        val btnRating = findViewById<Button>(R.id.btnAvrage)
        val btnShow = findViewById<Button>(R.id.btnShowPlaylist)
        val btnBack = findViewById<Button>(R.id.btnReturn)

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

        btnShow.setOnClickListener {

            txtSong.text = txtSongBuilder.toString()
            txtArtist.text = txtArtistBuilder.toString()
            txtRating.text = txtRatingBuilder.toString()
            txtComment.text = txtCommentBuilder.toString()
        }

        btnRating.setOnClickListener {
            if (Ratings != null && Ratings.isNotEmpty()){

                val total = Ratings.sum()
                val count = Ratings.count{it != 0}
                val average = if (count >0) total.toDouble() / count else 0.0
                txtAvgRating.text = "The Rating Average is: %.2f".format(average)

            }else {
                txtAvgRating.text = "Sorry there is no Rating Average."
            }


        }

        btnBack.setOnClickListener {

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
            finish()
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}