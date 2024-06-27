package com.example.listanime

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val backHome: ImageView = findViewById(R.id.toolbar_back_icon)
        backHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.toolbar_back_icon -> {
                val kembali = Intent(this@MainActivity2, MainActivity::class.java)
                startActivity(kembali)
            }
        }
    }
}