package com.haroldcalayan.dogs.di

import com.haroldcalayan.dogs.BuildConfig
import com.haroldcalayan.dogs.data.source.remote.service.DogsApiService
import com.haroldcalayan.dogs.util.provideApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHttpClient(okHttpBuilder: OkHttpClient.Builder) = okHttpBuilder.build()

    @Provides
    fun provideHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
        }
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return httpLoggingInterceptor
    }

    @Provides
    fun provideGithubApi(client: OkHttpClient): DogsApiService {
        return provideApi(BuildConfig.BASE_APP_URL, client)
    }

}