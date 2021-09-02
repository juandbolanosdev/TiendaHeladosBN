package com.example.bottomnavtienda.di

import com.example.bottomnavtienda.data.repositories.CommentRepository
import com.example.bottomnavtienda.data.repositories.HomeRepository
import com.example.bottomnavtienda.data.repositories.ProductRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModule = module{
    single { HomeRepository(get()) }
    single { CommentRepository(get())}
    single { ProductRepository(get())}
}