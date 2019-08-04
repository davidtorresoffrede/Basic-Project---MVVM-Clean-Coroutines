package com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.usecase.BaseUseCase
import com.example.davidoffrede.myapplication.core.presentation.mapper.ItemDomainToViewMapper
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.core.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class ListViewModel(val getItensUseCase: BaseUseCase<List<ItemDomain>, BaseUseCase.None>) : BaseViewModel() {

    val itens = MutableLiveData<List<Item>>()

    fun getItens() {
        jobs add launch {
//            loading.value = true
            try {
                itens.value = getItensUseCase.run(BaseUseCase.None()).await().map {
                    ItemDomainToViewMapper.transform(it)
                }
            } catch(t: Throwable) {
                itens.value = emptyList()
            }
            finally {
//                loading.value = false
            }
        }
    }

}