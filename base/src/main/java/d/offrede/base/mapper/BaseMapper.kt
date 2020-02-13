package d.offrede.base.mapper

abstract class BaseMapper<T, R> {
    abstract fun transform(source: T): R
}