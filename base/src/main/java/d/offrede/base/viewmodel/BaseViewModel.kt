package d.offrede.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val failureLiveData: MutableLiveData<ViewModelResult.Failure> = MutableLiveData()
    private val loadingLiveData: MutableLiveData<ViewModelResult.Loading> = MutableLiveData()

    fun failureLiveData() = failureLiveData

    fun loadingLiveData() = loadingLiveData


    protected fun handleFailure(message: String) {
        this.failureLiveData.value = ViewModelResult.Failure(message)
    }

    protected fun showLoading() {
        this.loadingLiveData.value = ViewModelResult.Loading(true)
    }

    protected fun hideLoading() {
        this.loadingLiveData.value = ViewModelResult.Loading(false)
    }

}