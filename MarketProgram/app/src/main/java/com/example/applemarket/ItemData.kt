package com.example.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemData(
    val num: Int, val image: Int, val name: String,
    val des: String, val seller: String, val price: Int,
    val address: String, val heart: Int, val chat: Int
) :Parcelable
