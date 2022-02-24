package com.khs.khs_ui.model

import androidx.annotation.DrawableRes

data class RoomItem(
    val title: String,
    @DrawableRes val imageRes: Int,
    val price: String
)