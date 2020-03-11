package com.example.davidoffrede.myapplication.feature.list.presentation.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davidoffrede.myapplication.R
import com.example.davidoffrede.myapplication.feature.detail.presentation.view.DetailActivity
import com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel.ListViewModel
import d.offrede.base.view.BaseAdapter
import d.offrede.base.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment() {

    private val viewModel: ListViewModel by viewModel()

    override fun layoutId() = R.layout.fragment_list

    override fun baseViewModel() = viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showItens()
        getItens(savedInstanceState)
    }

    private fun showItens() {
        viewModel.resultLiveData().observe(this, {
            recycler.apply {
                visibility = View.VISIBLE
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = BaseAdapter(it.data) {
                    ListViewHolder(it) { item ->
                        startActivity(DetailActivity.newIntent(context, item))
                    }
                }
            }
        }, {
            recycler.visibility = View.INVISIBLE
        }, {
            recycler.visibility = View.GONE
        })
    }

    private fun getItens(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            return
        }

        viewModel.getItens()
    }
}