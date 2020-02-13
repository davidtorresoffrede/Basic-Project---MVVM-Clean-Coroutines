package com.example.davidoffrede.myapplication.core.presentation.mapper

import d.offrede.base.mapper.BaseMapper
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.presentation.model.Item

object ItemDomainToViewMapper : BaseMapper<ItemDomain, Item>() {
    override fun transform(source: ItemDomain): Item {
        return Item(source.title)
    }
}