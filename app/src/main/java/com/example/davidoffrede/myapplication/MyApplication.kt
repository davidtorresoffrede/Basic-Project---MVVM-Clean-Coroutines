package com.example.davidoffrede.myapplication

import android.app.Application
import com.example.davidoffrede.myapplication.core.data.di.apiModule
import com.example.davidoffrede.myapplication.feature.list.presentation.di.listModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(
                apiModule,
                listModule
            )
        )

    }
}