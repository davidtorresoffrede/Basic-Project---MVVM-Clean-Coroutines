package d.offrede.base.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val failureLiveData: BaseLiveData<ViewModelResult.Failure> = BaseLiveData()
    private val loadingLiveData: BaseLiveData<ViewModelResult.Loading> = BaseLiveData()

    fun failureLiveData() = failureLiveData

    fun loadingLiveData() = loadingLiveData


    protected fun showFailure(message: String) {
        this.failureLiveData.makeVisible(ViewModelResult.Failure(message))
    }

    protected fun hideFailure() {
        this.failureLiveData.makeGone(ViewModelResult.Failure(""))
    }

    protected fun showLoading() {
        this.loadingLiveData.makeVisible(ViewModelResult.Loading())
    }

    protected fun hideLoading() {
        this.loadingLiveData.makeGone(ViewModelResult.Loading())
    }

}