package com.example.davidoffrede.myapplication.feature.list.data.repository

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.feature.list.domain.repository.GetItensRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class GetItensRepositoryImplementation : GetItensRepository {
    override suspend fun getItens() = withContext(IO) {
        async {
            //            api.getAll().await().map {
//                it.toModel()
//            }
            delay(2000L)
            listOf(ItemDomain("aha!"))
        }
    }
}