package com.sopt.android_hyebin.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imageBind")
    fun setImage(imageView: ImageView, imageUrl: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .circleCrop()
            .into(imageView)

    }
}