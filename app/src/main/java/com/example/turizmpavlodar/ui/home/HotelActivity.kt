package com.example.turizmpavlodar.ui.home

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.turizmpavlodar.R

class HotelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)
        val imageView = findViewById<ImageView>(R.id.placeImage)
        val title =  findViewById<TextView>(R.id.title)
        val rating = findViewById<TextView>(R.id.rating)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val phone = findViewById<TextView>(R.id.phone)
        val about = findViewById<TextView>(R.id.textViewAbout)
        val hours = findViewById<TextView>(R.id.hours)
        val location = findViewById<TextView>(R.id.directions)
        val position = getIntent().getIntExtra("position", 0)
        val titleString = getIntent().getStringExtra("name")
        val image = getIntent().getIntExtra("image", R.drawable.sever)
        val ratingDouble  = getIntent().getDoubleExtra("rating", 4.0)

        hours.setText("8:00 - 00:00")
        phone.text = "+77476313345"

        imageView.setImageResource(image)
        title.setText(titleString)
        rating.setText(ratingDouble.toString())
        ratingBar.numStars = 5
        ratingBar.rating = ratingDouble.toFloat()

        when(position){
            0-> {
                about.setText(R.string.saryarka_info)
                location.setText(R.string.loc_saruarka)
            }
            1-> {
                about.setText(R.string.irtysh_info)
                location.setText(R.string.loc_irtish)
            }
            2-> {
                about.setText(R.string.dvin_info)
                location.setText(R.string.loc_dvin)
            }
            3-> {
                about.setText(R.string.sever_info)
                location.setText(R.string.loc_sever)
            }
            4-> {
                about.setText(R.string.garden_park_info)
                location.setText(R.string.loc_garden)
            }

        }
    }
}