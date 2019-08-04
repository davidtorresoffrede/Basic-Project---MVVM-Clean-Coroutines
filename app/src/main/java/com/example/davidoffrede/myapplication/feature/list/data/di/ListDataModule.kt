package com.example.davidoffrede.myapplication.feature.list.data.di

import com.example.davidoffrede.myapplication.feature.list.data.repository.GetItensRepositoryImplementation
import com.example.davidoffrede.myapplication.feature.list.domain.repository.GetItensRepository
import org.koin.dsl.module.module

val listDataModule = module {

    single<GetItensRepository> { GetItensRepositoryImplementation() }

}