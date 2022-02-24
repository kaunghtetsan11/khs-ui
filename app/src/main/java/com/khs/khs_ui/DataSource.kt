package com.khs.khs_ui

import com.khs.khs_ui.model.FacilityItem
import com.khs.khs_ui.model.HotelItem
import com.khs.khs_ui.model.RateItem
import com.khs.khs_ui.model.RoomItem

object DataSource {
    val hotels = listOf(
        HotelItem(
            id = 1,
            name = "Lotte Hotel Yangon",
            address = "56 Pyay Road, Hlaing Township, 112345 Yangon, Myanmar",
            imageRes = R.drawable.hotel_1,
        ),
        HotelItem(
            id = 2,
            name = "Pan Pacific Yangon",
            address = "NO 32 Thidaoo Road, Latha Township, 12345 Yangon, Myanmar",
            imageRes = R.drawable.hotel_2,
        ),
        HotelItem(
            id = 3,
            name = "Chatrium Hotel Royal Lake Yangon",
            address = "40 Natmauk Road, Tamwe Township, 11211 Yangon, Myanmar",
            imageRes = R.drawable.hotel_3,
        )
    )
    val facilityList = listOf(
        FacilityItem(
            name = "Amenities",
            imageRes = R.drawable.theme
        ),
        FacilityItem(
            name = "F&B",
            imageRes = R.drawable.fnb
        ),
        FacilityItem(
            name = "Wifi",
            imageRes = R.drawable.wifi
        ),
        FacilityItem(
            name = "Facilities",
            imageRes = R.drawable.workouk
        ),
    )

    val roomList = listOf(
        RoomItem(
            title = "With Pool",
            imageRes = R.drawable.hotel_4,
            price = "230.23"
        ),
        RoomItem(
            title = "Deluxe Twin",
            imageRes = R.drawable.hotel_5,
            price = "130.23"
        ),
        RoomItem(
            title = "Deluxe King Deluxe",
            imageRes = R.drawable.hotel_6,
            price = "330.23"
        )
    )

    val rateList = listOf(
        RateItem(
            title = "Mobile App Special Voucher",
            price = "300",
            isMember = true
        ),
        RateItem(
            title = "Weekend Staycation",
            price = "125",
            isMember = false
        ),
        RateItem(
            title = "Weekend Staycation",
            price = "125",
            isMember = false
        )
    )
}