package d.offrede.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import d.offrede.base.viewmodel.ViewModelResult.*

abstract class BaseViewModel : ViewModel() {

    val resultLiveData: MutableLiveData<ViewModelResult> = MutableLiveData()

    protected fun handleFailure(exception: Throwable) {
        this.resultLiveData.value = Failure(exception)
    }

    protected fun <T: Any> handleSuccess(result: T) {
        this.resultLiveData.value = Success(result)
    }

}