package com.example.dipractice2.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.dipractice2.R

fun ImageView.setImage(url:String) {

    if (url.isNotEmpty()) {
        Glide.with(context).load(url).error(R.drawable.ic_launcher_background)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_launcher_background)
    }
}