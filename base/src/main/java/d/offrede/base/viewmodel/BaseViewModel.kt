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


    open fun showFailure(message: String = "") {
        hideEmpty()
        hideLoading()
        this.failureLiveData.makeVisible(Failure(message))
    }

    open fun hideFailure() {
        this.failureLiveData.makeGone(Failure())
    }

    open fun showEmpty(message: String = "") {
        hideFailure()
        hideLoading()
        this.emptyLiveData.makeVisible(Empty(message))
    }

    open fun hideEmpty() {
        this.emptyLiveData.makeGone(Empty())
    }

    open fun showLoading() {
        hideFailure()
        hideEmpty()
        this.loadingLiveData.makeVisible(Loading())
    }

    open fun hideLoading() {
        this.loadingLiveData.makeGone(Loading())
    }

}