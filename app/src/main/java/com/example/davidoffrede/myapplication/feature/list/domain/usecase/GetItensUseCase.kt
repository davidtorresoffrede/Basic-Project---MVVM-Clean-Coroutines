package com.example.davidoffrede.myapplication.feature.list.domain.usecase

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.usecase.BaseUseCase
import com.example.davidoffrede.myapplication.feature.list.domain.repository.GetItensRepository
import kotlinx.coroutines.Deferred

class GetItensUseCase(val repository: GetItensRepository) : BaseUseCase<List<ItemDomain>, BaseUseCase.None>() {
    override suspend fun run(params: None): Deferred<List<ItemDomain>> {
        return repository.getItens()
    }
}