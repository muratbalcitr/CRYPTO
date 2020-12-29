package com.murat.invio.binding

 import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
 import coil.api.load
 import com.pixplicity.sharp.Sharp

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    imageView.load(url)
}
/*

@BindingAdapter("app:svgLoader")
fun svgLoadImage(imageView: ImageView, url: String?) {
    Sharp.loadResource( url).into(imageView)
}
*/

@BindingAdapter("app:clickable")
fun bindButtonTitle(imageView: ImageView, clickable: Boolean) {
    imageView.isClickable = clickable
}

@BindingAdapter("imageDrawable")
fun loadImage(imageView: ImageView,  url: Drawable?) {
    imageView.setImageDrawable(url)
}
@BindingAdapter("app:textColor")
fun textColor(textView: AppCompatTextView,  color: String?) {
    textView.setTextColor(Color.parseColor(color))
}