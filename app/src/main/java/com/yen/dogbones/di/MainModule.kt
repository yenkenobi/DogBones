package com.yen.dogbones.di

import com.yen.dogbones.BuildConfig
import com.yen.dogbones.data.api.Api
import com.yen.dogbones.data.service.ImageRepository
import com.yen.dogbones.data.service.ImageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class MainModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val loggingLevel =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        val interceptor = HttpLoggingInterceptor().apply { level = loggingLevel }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesApi(okHttpClient: OkHttpClient): Api = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://dog.ceo/api/")
        .client(okHttpClient)
        .build()
        .create(Api::class.java)
}