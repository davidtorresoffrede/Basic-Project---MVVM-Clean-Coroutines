package d.offrede.base.viewmodel

sealed class ViewModelResult {
    class Success<out T : Any>(val data: T) : ViewModelResult()
    class Loading(val showLoading: Boolean) : ViewModelResult()
    class Failure(val exception: Throwable) : ViewModelResult()

    class None
}