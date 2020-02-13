package com.example.davidoffrede.myapplication.core.data.mapper

import com.example.davidoffrede.myapplication.core.data.model.ItemData
import d.offrede.base.mapper.BaseMapper
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain

object ItemDataToDomainMapper : BaseMapper<ItemData, ItemDomain>() {
    override fun transform(source: ItemData): ItemDomain {
        return ItemDomain(source.title)
    }
}