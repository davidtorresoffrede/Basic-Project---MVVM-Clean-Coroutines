package com.example.davidoffrede.myapplication.core.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadFromUrl(url: String) {
    Glide.with(this)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(android.R.drawable.ic_dialog_alert)
                .fitCenter()
                .override(100)
        )
        .into(this)
}