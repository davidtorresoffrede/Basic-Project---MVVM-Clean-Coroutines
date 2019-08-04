package com.example.davidoffrede.myapplication.core.data.repository

import android.util.Log
import com.example.davidoffrede.myapplication.core.data.mapper.ItemDataToDomainMapper
import com.example.davidoffrede.myapplication.core.data.model.ItemData
import com.example.davidoffrede.myapplication.core.data.service.ApiService
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.repository.ApiRepository
import com.example.davidoffrede.myapplication.core.domain.usecase.UseCaseResult
import kotlinx.coroutines.*

class ApiRepositoryImplementation(private val apiService: ApiService) : ApiRepository {

    override suspend fun getItens(): UseCaseResult<List<ItemDomain>> {
        return try {
            val result = apiService.getItens().await()
            if (result.isSuccessful) {
                val data : List<ItemData>? = result.body()

                data?.let {itens ->
                    UseCaseResult.Success(itens.map {
                        ItemDataToDomainMapper.transform(it)
                    })
                } ?: run {
                    UseCaseResult.Error(Exception())
                }

            } else {
                UseCaseResult.Error(Exception())
            }
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }

}