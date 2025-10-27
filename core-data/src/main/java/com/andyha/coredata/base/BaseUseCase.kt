package com.lucas.coredata.base

interface BaseUseCase<in Input, out Output> {
    operator fun invoke(params: Input): Output
}

interface NoInputUseCase<out Output> {
    operator fun invoke(): Output
}