package com.example.davidoffrede.myapplication.core.data.di

import com.example.davidoffrede.myapplication.core.data.repository.ApiRepositoryImplementation
import com.example.davidoffrede.myapplication.core.data.service.ApiService
import com.example.davidoffrede.myapplication.core.domain.repository.ApiRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.ConnectionSpec
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

const val BASE_URL = "https://api.github.com/"

val apiModule = module {

    single<GsonConverterFactory> { GsonConverterFactory.create(get()) }

    single<Gson> { GsonBuilder().create() }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>(named("logger")))
            .addInterceptor(get<Interceptor>(named("headers")))
            .build()
    }

    single<Interceptor>(named("logger")) {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        logger
    }

    single(named("headers")) {
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
            .addConverterFactory(get<GsonConverterFactory>())
            .baseUrl(BASE_URL).build()
    }

    single<ApiService>(named("ApiService")) {
        get<Retrofit>().create(ApiService::class.java)
    }

    single<ApiRepository> {
        ApiRepositoryImplementation(get(named("ApiService")))
    }
}