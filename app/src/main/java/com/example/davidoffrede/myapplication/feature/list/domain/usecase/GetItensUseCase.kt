package com.example.davidoffrede.myapplication.feature.list.domain.usecase

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.repository.ApiRepository
import d.offrede.base.usecase.BaseUseCase
import d.offrede.base.usecase.UseCaseResult

class GetItensUseCase(val repository: ApiRepository) : BaseUseCase<List<ItemDomain>, BaseUseCase.None>() {
    override suspend fun run(params: None): UseCaseResult<List<ItemDomain>> {
        return repository.getItens()
    }
}