package com.example.davidoffrede.myapplication.feature.list.presentation.di

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.usecase.BaseUseCase
import com.example.davidoffrede.myapplication.feature.list.domain.usecase.GetItensUseCase
import com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel.ListViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val listModule = module {

    single<BaseUseCase<List<ItemDomain>, BaseUseCase.None>>("GetItensUseCase") { GetItensUseCase(get()) }

//    factory { SectionedRecyclerViewAdapter() }

    viewModel { ListViewModel(get("GetItensUseCase")) }

}