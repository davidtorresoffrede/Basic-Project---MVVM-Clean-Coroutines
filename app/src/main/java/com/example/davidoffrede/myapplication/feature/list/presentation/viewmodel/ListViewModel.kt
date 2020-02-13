package com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.presentation.mapper.ItemDomainToViewMapper
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.core.presentation.viewmodel.CommonViewModel
import d.offrede.base.usecase.BaseUseCase
import d.offrede.base.usecase.UseCaseResult
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(val getItensUseCase: BaseUseCase<List<ItemDomain>, BaseUseCase.None>) : CommonViewModel() {

    val itens = MutableLiveData<List<Item>>()

    fun getItens() {
        jobs add launch {

            val result = withContext(IO) { getItensUseCase.run(BaseUseCase.None()) }

            when (result) {
                is UseCaseResult.Success -> itens.value = result.data.map {
                    ItemDomainToViewMapper.transform(it)
                }
                is UseCaseResult.Failure -> itens.value = listOf()
            }
        }
    }

}