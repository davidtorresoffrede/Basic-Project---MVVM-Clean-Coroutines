package com.example.davidoffrede.myapplication.core.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.davidoffrede.myapplication.R
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.include_toolbar.toolbar

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_container)
        setSupportActionBar(toolbar)
    }

    override fun setContentView(layoutResID: Int) {
        layoutInflater.inflate(layoutResID, activityContainer, true)
    }
}