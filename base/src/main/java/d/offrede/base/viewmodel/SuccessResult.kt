package d.offrede.base.viewmodel

sealed class SuccessResult<out T : Any> {
    class Success<out T : Any>(val data: T): SuccessResult<T>()
}