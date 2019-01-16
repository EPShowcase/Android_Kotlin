package info.megahard.epshowcase.app

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream
import java.util.concurrent.TimeUnit


@GlideModule
class MyGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(YOUR_CUSTOM_TIMEOUT, TimeUnit.SECONDS)
        builder.writeTimeout(YOUR_CUSTOM_TIMEOUT, TimeUnit.SECONDS)
        builder.connectTimeout(YOUR_CUSTOM_TIMEOUT, TimeUnit.SECONDS)
        registry.append(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(builder.build()))
    }

    companion object {
        const val YOUR_CUSTOM_TIMEOUT = 20000L
    }
}