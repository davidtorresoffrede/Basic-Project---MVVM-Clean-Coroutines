package com.example.davidoffrede.myapplication.core.domain.mapper

abstract class BaseMapper<T, R> {
    abstract fun transform(source: T): R
}