package com.example.davidoffrede.myapplication.feature.list.presentation.view

import android.os.Bundle
import com.example.davidoffrede.myapplication.R
import d.offrede.base.view.BaseActivity

class ListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.list_screen_title)
    }

    override fun fragment() = ListFragment()
}