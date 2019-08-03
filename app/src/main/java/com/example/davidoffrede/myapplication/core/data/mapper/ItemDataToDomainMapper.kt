package com.example.davidoffrede.myapplication.core.data.mapper

import com.example.davidoffrede.myapplication.core.data.model.ItemData
import com.example.davidoffrede.myapplication.core.domain.mapper.BaseMapper
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain

class ItemDataToDomainMapper : BaseMapper<ItemData, ItemDomain>() {
    override fun transform(source: ItemData): ItemDomain {
        return ItemDomain(source.title)
    }
}