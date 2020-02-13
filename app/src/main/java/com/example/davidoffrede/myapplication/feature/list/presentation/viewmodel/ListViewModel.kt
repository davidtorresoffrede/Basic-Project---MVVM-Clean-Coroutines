package com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.presentation.mapper.ItemDomainToViewMapper
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.core.presentation.viewmodel.CommonViewModel
import d.offrede.base.usecase.BaseUseCase
import d.offrede.base.usecase.UseCaseResult
import d.offrede.base.viewmodel.SuccessResult
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(
    private val getItensUseCase: BaseUseCase<List<ItemDomain>, BaseUseCase.None>
) : CommonViewModel() {

    private val resultLiveData: MutableLiveData<SuccessResult<List<Item>>> = MutableLiveData()

    fun resultLiveData() = resultLiveData

    fun getItens() {
        jobs add launch {

            val result = withContext(IO) { getItensUseCase.run(BaseUseCase.None()) }

            when (result) {
                is UseCaseResult.Success -> handleSuccess(
                    SuccessResult.Success(
                        result.data.map {
                            ItemDomainToViewMapper.transform(it)
                        }
                    )
                )
                is UseCaseResult.Failure -> handleSuccess(SuccessResult.Success(listOf<Item>()))
            }
        }
    }

    private fun handleSuccess(successResult: SuccessResult<List<Item>>) {
        this.resultLiveData.value = successResult
    }

}