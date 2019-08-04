package com.example.davidoffrede.myapplication.feature.list.domain.repository

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import kotlinx.coroutines.Deferred

interface GetItensRepository {

    suspend fun getItens(): Deferred<List<ItemDomain>>

}