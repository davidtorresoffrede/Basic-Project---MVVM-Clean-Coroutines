package d.offrede.base.viewmodel

sealed class LoadingResult {
    object ShowLoading: LoadingResult()
    object DismissLoading: LoadingResult()
}