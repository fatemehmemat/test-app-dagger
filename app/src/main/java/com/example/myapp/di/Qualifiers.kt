package com.example.myapp.di

import javax.inject.Qualifier

@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
internal annotation class ApplicationContext


@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
internal annotation class CacheBase
