package com.example.davidoffrede.myapplication.feature.list.presentation.viewmodel

import com.example.davidoffrede.myapplication.core.domain.model.ItemDomain
import com.example.davidoffrede.myapplication.core.presentation.mapper.ItemDomainToViewMapper
import com.example.davidoffrede.myapplication.core.presentation.model.Item
import com.example.davidoffrede.myapplication.core.presentation.viewmodel.CommonViewModel
import d.offrede.base.usecase.BaseUseCase
import d.offrede.base.usecase.UseCaseResult
import d.offrede.base.viewmodel.BaseLiveData
import d.offrede.base.viewmodel.ViewModelResult.Success
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import d.offrede.base.viewmodel.VisibilityStatus.GONE

class ListViewModel(
    private val getItensUseCase: BaseUseCase<List<ItemDomain>, BaseUseCase.None>
) : CommonViewModel() {

    private val resultLiveData: BaseLiveData<Success<List<Item>>> = BaseLiveData()

    fun resultLiveData() = resultLiveData

    fun getItens() {
        jobs add launch {
            showLoading("Aguarde...")
            val result = withContext(IO) { getItensUseCase.run(BaseUseCase.None()) }
            hideLoading()
            when (result) {
                is UseCaseResult.Success -> {
                    val listItens = result.data.map {
                        ItemDomainToViewMapper.transform(it)
                    }

                    if (listItens.isNotEmpty()) {
                        showSuccess(listItens)
                    } else {
                        showEmpty("Lista vazia")
                    }
                }
                is UseCaseResult.Failure -> {
                    showFailure("Ocorreu um erro inesperado")
                }
            }
        }
    }

    private fun showSuccess(data: List<Item>) {
        this.resultLiveData.makeVisible(Success(data))
        hideEmpty()
        hideFailure()
        hideLoading()
    }

    private fun hideSuccess() {
        this.resultLiveData.value =
            GONE to Success(this.resultLiveData.value?.second?.data ?: listOf())
    }

    override fun showLoading(message: String) {
        super.showLoading(message)
        hideSuccess()
    }

    override fun showEmpty(message: String) {
        super.showEmpty(message)
        hideSuccess()
    }

    override fun showFailure(message: String) {
        super.showFailure(message)
        hideSuccess()
    }

}