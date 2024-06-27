package com.example.listanime

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileImage: CircleImageView = findViewById(R.id.about_page)
        profileImage.setOnClickListener(this)

        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)

        list.addAll(getListAnime())
        showRecyclerList()
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.about_page -> {
                val pindahDetail = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(pindahDetail)
            }
        }
    }

    @SuppressLint("Recycle")
    private fun getListAnime(): ArrayList<Anime> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataStatus = resources.getStringArray(R.array.data_status) // Ambil array status

        val listAnime = ArrayList<Anime>()
        for (i in dataName.indices) {
            val anime = Anime(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataStatus[i]) // Tambahkan status
            listAnime.add(anime)
        }
        return listAnime
    }


    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(list)
        rvAnime.adapter = listAnimeAdapter

        listAnimeAdapter.setOnItemClickCallback(object : ListAnimeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Anime) {
                showSelectedAnime(data)

                val intent = Intent(this@MainActivity, DetailAnime::class.java)
                intent.putExtra(INTENT_PARCELABLE, data)
                startActivity(intent)
            }
        })
    }

    private fun showSelectedAnime(anime: Anime) {
        Toast.makeText(this, "You choose " + anime.name, Toast.LENGTH_SHORT).show()
    }
}