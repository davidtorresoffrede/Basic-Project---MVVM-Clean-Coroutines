package com.example.davidoffrede.myapplication

import android.app.Application
import com.example.davidoffrede.myapplication.feature.list.data.di.listDataModule
import com.example.davidoffrede.myapplication.feature.list.presentation.di.listModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(
                listModule,
                listDataModule
            )
        )

    }
}