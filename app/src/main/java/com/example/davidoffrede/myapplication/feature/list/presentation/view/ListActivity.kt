package com.example.davidoffrede.myapplication.feature.list.presentation.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davidoffrede.myapplication.R
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import d.offrede.base.view.BaseActivity
import com.example.davidoffrede.myapplication.feature.detail.presentation.view.DetailActivity
import com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel.ListViewModel
import d.offrede.base.viewmodel.SuccessResult
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListActivity : BaseActivity() {

    private val viewModel: ListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = getString(R.string.list_screen_title)

        showItens()
        getItens(savedInstanceState)
    }

    private fun showItens() {
        viewModel.resultLiveData().observe(this, Observer<SuccessResult<List<Item>>> {
            when (it) {
                is SuccessResult.Success -> {
                    with(recycler) {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = ListAdapter(it.data) {
                            startActivity(DetailActivity.newIntent(this@ListActivity, it))
                        }
                    }
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