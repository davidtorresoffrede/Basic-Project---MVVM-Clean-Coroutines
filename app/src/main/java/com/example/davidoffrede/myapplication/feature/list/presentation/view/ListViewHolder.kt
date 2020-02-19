package com.example.davidoffrede.myapplication.feature.list.presentation.view

import android.view.ViewGroup
import android.widget.TextView
import com.example.davidoffrede.myapplication.R
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import d.offrede.base.view.BaseViewHolder

class ListViewHolder(itemView: ViewGroup, private val click: (Item) -> Unit = { _ -> }) : BaseViewHolder<Item>(itemView, R.layout.adapter_list) {
    override fun bind(item: Item) {
        itemView.findViewById<TextView>(R.id.text).text = item.title

        itemView.setOnClickListener {
            click(item)
        }
    }
}