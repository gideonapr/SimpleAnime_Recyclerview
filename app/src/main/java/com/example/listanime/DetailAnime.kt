@file:Suppress("DEPRECATION")

package com.example.listanime

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailAnime : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anime)

        val anime = intent.getParcelableExtra<Anime>(MainActivity.INTENT_PARCELABLE)

        val name = findViewById<TextView>(R.id.tv_item_name)
        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val description = findViewById<TextView>(R.id.tv_item_status)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        photo.setImageResource(anime?.photo!!)
        name.text = anime.name
        description.text = anime.description
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}