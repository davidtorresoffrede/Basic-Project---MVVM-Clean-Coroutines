package d.offrede.base.usecase

abstract class BaseUseCase<Type, in Params> where Type : Any {
    abstract suspend fun run(params: Params): UseCaseResult<Type>

    class None
}