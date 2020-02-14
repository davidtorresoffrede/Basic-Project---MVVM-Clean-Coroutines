package com.example.davidoffrede.myapplication.feature.list.presentation.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davidoffrede.myapplication.R
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import d.offrede.base.view.BaseActivity
import com.example.davidoffrede.myapplication.feature.detail.presentation.view.DetailActivity
import com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel.ListViewModel
import d.offrede.base.viewmodel.ViewModelResult
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

    override fun baseViewModel() = viewModel

    private fun showItens() {
        viewModel.resultLiveData().observe(this, Observer<ViewModelResult<List<Item>>> {
            when (it) {
                is ViewModelResult.Success -> {
                    with(recycler) {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = ListAdapter(it.data) { item ->
                            startActivity(DetailActivity.newIntent(this@ListActivity, item))
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