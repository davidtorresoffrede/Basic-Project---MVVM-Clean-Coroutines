package d.offrede.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val failureLiveData: MutableLiveData<ViewModelResult.Failure> = MutableLiveData()
    private val loadingLiveData: MutableLiveData<ViewModelResult.Loading> = MutableLiveData()

    fun failureLiveData() = failureLiveData

    fun loadingLiveData() = loadingLiveData


    protected fun handleFailure(failureResult: ViewModelResult.Failure) {
        this.failureLiveData.value = failureResult
    }

    protected fun handleLoading(loadingResult: ViewModelResult.Loading) {
        this.loadingLiveData.value = loadingResult
    }

}