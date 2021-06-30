package com.haroldcalayan.dogs.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.haroldcalayan.dogs.R

@BindingAdapter("android:src")
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(view)
}