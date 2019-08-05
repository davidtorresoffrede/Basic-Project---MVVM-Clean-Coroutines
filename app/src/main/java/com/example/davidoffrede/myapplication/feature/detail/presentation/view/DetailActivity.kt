package com.example.davidoffrede.myapplication.feature.detail.presentation.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.davidoffrede.myapplication.R
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.core.presentation.view.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = getString(R.string.detail_screen_title)

        loadExtras()
    }

    private fun loadExtras() {
        text.text =  intent.getParcelableExtra<Item>(INTENT_EXTRA_PARAM_ITEM).title
    }

    companion object {
        private const val INTENT_EXTRA_PARAM_ITEM = "INTENT_EXTRA_PARAM_ITEM"

        fun newIntent(context: Context, item: Item): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_ITEM, item)
            return intent
        }
    }
}
