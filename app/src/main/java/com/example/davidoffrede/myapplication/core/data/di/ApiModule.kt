package com.example.davidoffrede.myapplication.core.data.di

import com.example.davidoffrede.myapplication.core.data.repository.ApiRepositoryImplementation
import com.example.davidoffrede.myapplication.core.data.service.ApiService
import com.example.davidoffrede.myapplication.core.domain.repository.ApiRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.github.com/"

val apiModule = module {

    single { CoroutineCallAdapterFactory() }

    single<GsonConverterFactory> { GsonConverterFactory.create(get()) }

    single<Gson> { GsonBuilder().create() }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get("logger"))
            .addInterceptor(get("headers"))
            .build()
    }

    single<Interceptor>("logger") {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        logger
    }

    single("headers") {
        Interceptor { chain ->
            var request = chain.request()

            val builder = request.newBuilder()
                .addHeader("Content-Type", "application/json;charset=UTF-8")

            request = builder.build()
            chain.proceed(request)
        }
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .addCallAdapterFactory(get<CoroutineCallAdapterFactory>())
            .addConverterFactory(get<GsonConverterFactory>())
            .baseUrl(BASE_URL).build()
    }

    single<ApiService>("ApiService") {
        get<Retrofit>().create(ApiService::class.java)
    }

    single<ApiRepository> {
        ApiRepositoryImplementation(get("ApiService"))
    }
}