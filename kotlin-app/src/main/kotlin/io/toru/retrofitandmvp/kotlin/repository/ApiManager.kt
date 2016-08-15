package io.toru.retrofitandmvp.kotlin.repository

import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapterFactory
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitBuilder {

    fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/")
                .client(okhttp)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonBuilder().let {
                    it.registerTypeAdapterFactory(AppTypeAdapterFactory.create())
                    GsonConverterFactory.create(it.create())
                })
                .build()
    }


    companion object {
        private val okhttp: OkHttpClient by lazy {
            OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BASIC
                    })
                    .build()
        }
    }
}

@Module
class ApiModule {
    @Provides
    fun retrofit(): Retrofit {
        return RetrofitBuilder().retrofit()
    }
}

@GsonTypeAdapterFactory
abstract class AppTypeAdapterFactory : TypeAdapterFactory {
    companion object {
        @JvmStatic fun create(): TypeAdapterFactory {
            return AutoValueGson_AppTypeAdapterFactory()
        }
    }
}