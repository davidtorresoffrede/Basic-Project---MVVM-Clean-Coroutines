package com.example.davidoffrede.myapplication.feature.list

import android.os.Bundle
import com.example.davidoffrede.myapplication.R
import com.example.davidoffrede.myapplication.core.presentation.view.BaseActivity

class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


//        GlobalScope.launch(context = Dispatchers.Main) {
//            val orders = withContext(context = Dispatchers.IO) {
//                showHellow().await()
//            }
//
//            text.text = orders
//        }
    }

//    suspend fun showHellow() = GlobalScope.async {
//        delay(1000L)
//        "aha!"
//    }

}