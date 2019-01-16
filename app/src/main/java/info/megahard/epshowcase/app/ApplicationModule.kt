package info.megahard.epshowcase.app

import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import info.megahard.epshowcase.BuildConfig
import info.megahard.epshowcase.bio.BioService
import info.megahard.epshowcase.bio.BioViewModel
import info.megahard.epshowcase.net.MainApi
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import toothpick.config.Module

class ApplicationModule(app: App) : Module() {

    init {
        configCommon(app)
        configRetrofit(API_BASE_URL)

        bind(BioService::class.java).singletonInScope()
        bind(BioViewModel::class.java).singletonInScope()
    }

    private fun configCommon(app: App) {
        bind(Context::class.java).toInstance(app.applicationContext)
        bind(SharedPreferences::class.java).toInstance(app.getSharedPreferences(app.packageName, Context.MODE_PRIVATE))
        bind(Resources::class.java).toInstance(app.resources)
        bind(ContentResolver::class.java).toInstance(app.contentResolver)
    }

    private fun configRetrofit(baseUrl: String) {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .followRedirects(false)
            .build()

        val gson = GsonBuilder()
            .create()
        bind(Gson::class.java).toInstance(gson)

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        bind(MainApi::class.java).toInstance(retrofit.create(MainApi::class.java))
    }

    companion object {
        private val API_BASE_URL = "http://cv-api.megahard.info:3001/"
        val SCOPE_APPLICATION = "Application"
    }
}
