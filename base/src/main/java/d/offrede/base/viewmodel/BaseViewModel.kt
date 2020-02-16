package d.offrede.base.viewmodel

import androidx.lifecycle.ViewModel
import d.offrede.base.viewmodel.ViewModelResult.*

abstract class BaseViewModel : ViewModel() {

    private val failureLiveData: BaseLiveData<Failure> = BaseLiveData()
    private val emptyLiveData: BaseLiveData<Empty> = BaseLiveData()
    private val loadingLiveData: BaseLiveData<Loading> = BaseLiveData()

    fun failureLiveData() = failureLiveData

    fun emptyLiveData() = emptyLiveData

    fun loadingLiveData() = loadingLiveData


    protected fun showFailure(message: String) {
        this.failureLiveData.makeVisible(Failure(message))
    }

    protected fun hideFailure() {
        this.failureLiveData.makeGone(Failure(""))
    }

    protected fun showEmpty(message: String) {
        this.emptyLiveData.makeVisible(Empty(message))
    }

    protected fun hideEmpty() {
        this.emptyLiveData.makeGone(Empty(""))
    }

    protected fun showLoading() {
        this.loadingLiveData.makeVisible(Loading())
    }

    protected fun hideLoading() {
        this.loadingLiveData.makeGone(Loading())
    }

}