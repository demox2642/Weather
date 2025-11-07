package com.demox.core.data.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreDataModule {

    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(3L, TimeUnit.SECONDS)
            .addNetworkInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY),
            )
            .followRedirects(true)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit.Builder {
        val gson =
            GsonBuilder()
                .create()

        return Retrofit.Builder()
            .client(client)
            .baseUrl("http://api.weatherapi.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
}