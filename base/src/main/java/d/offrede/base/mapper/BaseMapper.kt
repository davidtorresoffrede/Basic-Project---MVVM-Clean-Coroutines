package d.offrede.base.mapper

abstract class BaseMapper<in T, out R> {
    abstract fun transform(source: T): R
}