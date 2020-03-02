package com.jvmori.myapplication.common.presentation.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.jvmori.myapplication.R
import com.jvmori.myapplication.common.data.Resource
import com.squareup.picasso.Picasso


@BindingAdapter("showImage")
fun loadImage(view: ImageView, url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.gradient)
        .into(view)
}

@BindingAdapter("showLoading")
fun showLoading(view: View, status: Resource.Status?) {
    view.visibility =
        if (status != null && status == Resource.Status.LOADING)
            View.VISIBLE
        else
            View.GONE
}

@BindingAdapter("showError")
fun showError(view: View, status: Resource.Status?){
    view.visibility =
        if (status != null && status == Resource.Status.ERROR)
            View.VISIBLE
        else
            View.GONE
}