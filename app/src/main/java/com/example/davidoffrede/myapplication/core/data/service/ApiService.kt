package com.example.davidoffrede.myapplication.core.data.service

import com.example.davidoffrede.myapplication.core.data.model.ItemData
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("orgs/octokit/repos")
    suspend fun getItens(): Response<List<ItemData>>

}