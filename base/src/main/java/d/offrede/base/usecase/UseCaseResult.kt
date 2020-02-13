package d.offrede.base.usecase

sealed class UseCaseResult<out T : Any> {
    class Success<out T : Any>(val data: T) : UseCaseResult<T>()
    class Failure(val exception: Throwable) : UseCaseResult<Nothing>()
}