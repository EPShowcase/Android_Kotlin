package info.megahard.epshowcase.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import info.megahard.epshowcase.R
import info.megahard.epshowcase.app.GlideApp

@BindingAdapter("networkImage")
fun networkImage(view: ImageView, url: String) {
    // FIXME: update url on server
    var fixedUrl = url
    if (fixedUrl == "http://cv-api.megahard.info:3000/images/ernest.jpg")
        fixedUrl = fixedUrl.replace("3000", "3001")

    GlideApp
        .with(view.context)
        .load(fixedUrl)
        .placeholder(R.drawable.oval)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}
