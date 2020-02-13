package com.example.davidoffrede.myapplication.feature.list.presentation.di

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import d.offrede.base.usecase.BaseUseCase
import com.example.davidoffrede.myapplication.feature.list.domain.usecase.GetItensUseCase
import com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val listModule = module {

    single<BaseUseCase<List<ItemDomain>, BaseUseCase.None>>(named("GetItensUseCase")) { GetItensUseCase(get()) }

    viewModel { ListViewModel(get(named("GetItensUseCase"))) }

}