package d.offrede.base.viewmodel

sealed class FailureResult {
    object NetworkConnection : FailureResult()
    object ServerError : FailureResult()
}