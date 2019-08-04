package com.example.davidoffrede.myapplication.core.domain.usecase

import kotlinx.coroutines.Deferred

abstract class BaseUseCase<Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Deferred<Type>

    class None
    
}