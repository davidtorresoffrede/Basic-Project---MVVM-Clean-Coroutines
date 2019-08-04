package com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.domain.usecase.BaseUseCase
import com.example.davidoffrede.myapplication.core.domain.usecase.UseCaseResult
import com.example.davidoffrede.myapplication.core.presentation.mapper.ItemDomainToViewMapper
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.core.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(val getItensUseCase: BaseUseCase<List<ItemDomain>, BaseUseCase.None>) : BaseViewModel() {

    val itens = MutableLiveData<List<Item>>()

    fun getItens() {
        jobs add launch {

            val result = withContext(IO) { getItensUseCase.run(BaseUseCase.None()) }

            when (result) {
                is UseCaseResult.Success -> itens.value = result.data.map {
                    ItemDomainToViewMapper.transform(it)
                }
                is UseCaseResult.Error -> itens.value = listOf()
            }
        }
    }

}