package d.offrede.base.viewmodel

sealed class SuccessResult {
    class Success<T : Any>(val data: T): SuccessResult()
}