package d.offrede.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val failureLiveData: MutableLiveData<FailureResult> = MutableLiveData()
    private val loadingLiveData: MutableLiveData<LoadingResult> = MutableLiveData()

    fun failureLiveData() = failureLiveData

    fun loadingLiveData() = loadingLiveData


    protected fun handleFailure(failureResult: FailureResult) {
        this.failureLiveData.value = failureResult
    }

    protected fun handleLoading(loadingResult: LoadingResult) {
        this.loadingLiveData.value = loadingResult
    }

}