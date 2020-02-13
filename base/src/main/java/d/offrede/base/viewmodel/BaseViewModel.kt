package d.offrede.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val resultLiveData: MutableLiveData<SuccessResult> = MutableLiveData()
    private val failureLiveData: MutableLiveData<FailureResult> = MutableLiveData()
    private val loadingLiveData: MutableLiveData<LoadingResult> = MutableLiveData()

    fun resultLiveData() = resultLiveData

    fun failureLiveData() = failureLiveData

    fun loadingLiveData() = loadingLiveData

    protected fun handleSuccess(successResult: SuccessResult) {
        this.resultLiveData.value = successResult
    }

    protected fun handleFailure(failureResult: FailureResult) {
        this.failureLiveData.value = failureResult
    }

    protected fun handleLoading(loadingResult: LoadingResult) {
        this.loadingLiveData.value = loadingResult
    }

}