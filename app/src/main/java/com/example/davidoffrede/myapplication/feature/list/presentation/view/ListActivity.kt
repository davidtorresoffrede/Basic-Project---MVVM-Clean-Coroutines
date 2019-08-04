package com.example.davidoffrede.myapplication.feature.list.presentation.view

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davidoffrede.myapplication.R
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.core.presentation.view.BaseActivity
import com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListActivity : BaseActivity() {

    private val viewModel: ListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        showItens()
        getItens(savedInstanceState)
    }

    private fun showItens() {
        viewModel.itens.observe(this, Observer<List<Item>> {
            with(recycler) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = ListAdapter(it) {
                    Toast.makeText(this@ListActivity, it.title, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun getItens(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            return
        }

        viewModel.getItens()
    }
}