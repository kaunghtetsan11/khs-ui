package com.khs.ui.binding

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(
    value = ["imageUrl", "image", "resImage", "imageUri"],
    requireAll = false
)
fun setImage(
    imageView: AppCompatImageView,
    imageUrl: String?,
    image: Drawable?,
    @DrawableRes resImage: Int?,
    imageUri: Uri?
) {

    Glide.with(imageView.context)
        .load(image ?: (resImage ?: (imageUrl ?: imageUri)))
        .into(imageView)
}

@BindingAdapter("render")
fun setViewRender(view: View, value: Boolean?) {
    value?.let {
        view.isVisible = it
    }
}