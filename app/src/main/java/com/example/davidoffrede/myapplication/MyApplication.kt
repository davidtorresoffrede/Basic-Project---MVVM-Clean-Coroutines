package com.example.davidoffrede.myapplication

import android.app.Application
import com.example.davidoffrede.myapplication.core.data.di.apiModule
import com.example.davidoffrede.myapplication.feature.list.presentation.di.listModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    apiModule,
                    listModule
                )
            )
        }
    }
}