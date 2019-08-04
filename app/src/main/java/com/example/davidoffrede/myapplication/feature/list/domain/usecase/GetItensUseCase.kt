package com.example.davidoffrede.myapplication.feature.list.domain.usecase

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.repository.ApiRepository
import com.example.davidoffrede.myapplication.core.domain.usecase.BaseUseCase
import com.example.davidoffrede.myapplication.core.domain.usecase.UseCaseResult
import kotlinx.coroutines.Deferred

class GetItensUseCase(val repository: ApiRepository) : BaseUseCase<List<ItemDomain>, BaseUseCase.None>() {
    override suspend fun run(params: None): UseCaseResult<List<ItemDomain>> {
        return repository.getItens()
    }
}