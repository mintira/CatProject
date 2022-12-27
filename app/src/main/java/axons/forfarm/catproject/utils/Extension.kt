package axons.forfarm.catproject.utils

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import axons.forfarm.catproject.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.signature.ObjectKey


fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>


fun ImageView.loadUrlCacheCenterCrop(
    context: Context,
    imageUrl: String,
    @DrawableRes placeHolder: Int = R.drawable.shape_rec_white,
    @DrawableRes errorDrawable: Int = R.drawable.bg_image_place_holder,
    signature: Any = 0
) {
    context.glideLoadCache(imageUrl, placeHolder, errorDrawable)
        .centerCrop()
        .signature(ObjectKey(signature))
        .into(this)
}

fun <T> Context.glideLoadCache(
    data: T?,
    @DrawableRes placeHolder: Int,
    @DrawableRes errorDrawable: Int
) =
    Glide.with(this).loadNoToken(data)
        .thumbnail(0.25f)
        .downsample(DownsampleStrategy.CENTER_INSIDE)
        .placeholder(placeHolder)
        .error(errorDrawable)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transition(DrawableTransitionOptions.withCrossFade())

private fun <T> RequestManager.loadNoToken(data: T?) =
    if ((data is String || data is Uri)
        && data.toString().isNotBlank()
    )
        load(GlideUrlNoToken(data.toString()))
    else
        load(data)

private class GlideUrlNoToken(url: String) : GlideUrl(url) {

    private val cacheKey: String?

    init {
        val index = url.indexOfAny(listOf("jpeg", "jpg", "png", "?"), ignoreCase = true)
        cacheKey = if (index > 0)
            url.substring(0, index)
        else
            null
    }

    override fun getCacheKey(): String {
        return cacheKey ?: super.getCacheKey()
    }

}