package com.example.listanime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val description: String,
    val photo: Int,
    val status: String
) :Parcelable