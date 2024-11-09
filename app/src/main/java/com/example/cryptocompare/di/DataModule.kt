package com.example.cryptocompare.di

import com.example.cryptocompare.data.repositories.CoinRepositoryImpl
import com.example.cryptocompare.domain.repositories.CoinRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository
}