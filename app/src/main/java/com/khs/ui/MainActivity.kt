package com.khs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.aemerse.slider.listener.CarouselListener
import com.aemerse.slider.listener.CarouselOnScrollListener
import com.aemerse.slider.model.CarouselItem
import com.aemerse.slider.utils.setImage
import com.khs.ui.databinding.ActivityMainBinding
import com.khs.ui.databinding.ItemHotelBinding
import com.khs.ui.adapter.FacilityAdapter
import com.khs.ui.adapter.RateAdapter
import com.khs.ui.adapter.RoomAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        setUpHotels()
        setUpFacility()
        setUpRoom()
        setUpRate()
        setListener()
    }

    private fun setUpHotels() {
        with(_binding) {
            sldImages.registerLifecycle(lifecycle)
            sldImages.carouselListener = object : CarouselListener {
                override fun onCreateViewHolder(
                    layoutInflater: LayoutInflater,
                    parent: ViewGroup
                ): ViewBinding {
                    return ItemHotelBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                    )
                }

                override fun onBindViewHolder(
                    binding: ViewBinding,
                    item: CarouselItem,
                    position: Int
                ) {
                    val currentBinding = binding as ItemHotelBinding
                    currentBinding.iv.apply {
                        scaleType = ImageView.ScaleType.FIT_XY
                        setImage(item)
                    }
                }
            }
            sldImages.onScrollListener = object : CarouselOnScrollListener {

                override fun onScrollStateChanged(
                    recyclerView: RecyclerView,
                    newState: Int,
                    position: Int,
                    carouselItem: CarouselItem?
                ) {

                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        carouselItem?.let {
                          val hotel =
                              DataSource.hotels.single { hotel -> hotel.imageRes == it.imageDrawable }
                            tvName.text = hotel.name
                            tvAddress.text = hotel.address
                            tvCount.text =
                                getString(
                                    R.string.see_all_format,
                                    hotel.id,
                                    DataSource.hotels.size
                                )
                        }
                    }
                }

                override fun onScrolled(
                    recyclerView: RecyclerView,
                    dx: Int,
                    dy: Int,
                    position: Int,
                    carouselItem: CarouselItem?
                ) {
                    // ...
                }
            }
            sldImages.setData(DataSource.hotels.map {
                CarouselItem(imageDrawable = it.imageRes)
            })
        }
    }

    private fun setUpFacility() {
        val adapter = FacilityAdapter()
        _binding.rvFacility.adapter = adapter
        adapter.submitList(DataSource.facilityList)
    }

    private fun setUpRoom() {
        val adapter = RoomAdapter()
        _binding.rvRoom.adapter = adapter
        adapter.submitList(DataSource.roomList)
    }

    private fun setUpRate() {
        val adapter = RateAdapter()
        _binding.rvRate.adapter = adapter
        adapter.submitList(DataSource.rateList)
    }

    private fun setListener() {
        with(_binding) {
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                rvRoom.isVisible = checkedId == R.id.radio_room
                rvRate.isVisible = checkedId == R.id.radio_rate
            }
            radioGroup.check(R.id.radio_room)
        }
    }
}