package com.murat.invio.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.murat.invio.R

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    url?.let {
        val imgUri =
            url.toUri().buildUpon().scheme("https").build()
        GlideToVectorYou
            .init()
            .with(imageView.context)
            .setPlaceHolder(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background)
            .load(imgUri, imageView)
    }
}


@BindingAdapter("app:clickable")
fun bindButtonTitle(imageView: ImageView, clickable: Boolean) {
    imageView.isClickable = clickable
}

@BindingAdapter("imageDrawable")
fun loadImage(imageView: ImageView, url: Drawable?) {
    imageView.setImageDrawable(url)
}