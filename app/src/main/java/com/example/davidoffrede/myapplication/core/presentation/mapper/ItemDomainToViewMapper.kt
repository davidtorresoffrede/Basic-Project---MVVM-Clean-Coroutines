package com.example.davidoffrede.myapplication.core.presentation.mapper

import com.example.davidoffrede.myapplication.core.domain.mapper.BaseMapper
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.presentation.model.Item

class ItemDomainToViewMapper : BaseMapper<ItemDomain, Item>() {
    override fun transform(source: ItemDomain): Item {
        return Item(source.title)
    }
}