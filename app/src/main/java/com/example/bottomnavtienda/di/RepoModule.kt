package com.example.bottomnavtienda.di

import com.example.bottomnavtienda.data.repositories.CommentRepository
import com.example.bottomnavtienda.data.repositories.HomeRepository
import com.example.bottomnavtienda.data.repositories.ProductRepository
import com.example.bottomnavtienda.data.repositories.UserRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModule = module{
    single { HomeRepository(get(),get()) }
    single { CommentRepository(get(),get())}
    single { ProductRepository(get(),get())}
    single { UserRepository(get(),get())}
}