package com.khs.khs_ui.model

import androidx.annotation.DrawableRes

data class HotelItem(
    val id: Int,
    val name: String,
    val address: String,
    @DrawableRes val imageRes: Int
)