package com.mehedi.platzi2205.utils

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import com.mehedi.platzi2205.R


fun ImageView.load(imageUrl:String){
    this.load(imageUrl) {
        placeholder(R.drawable.pls)
        error(R.drawable.pls_error)
        diskCachePolicy(CachePolicy.ENABLED)
    }
}