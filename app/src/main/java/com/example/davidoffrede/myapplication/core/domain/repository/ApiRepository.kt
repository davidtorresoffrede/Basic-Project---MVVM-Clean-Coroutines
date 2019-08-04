package com.example.davidoffrede.myapplication.core.domain.repository

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.usecase.UseCaseResult

interface ApiRepository {
    suspend fun getItens(): UseCaseResult<List<ItemDomain>>
}