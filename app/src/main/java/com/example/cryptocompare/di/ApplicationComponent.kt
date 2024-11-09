package com.example.cryptocompare.di

import com.example.cryptocompare.presentation.views.CoinInfoFragment
import com.example.cryptocompare.presentation.views.CoinTopListFragment
import dagger.Component

@ApplicationScope
@Component (modules = [DomainModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(coinTopListFragment: CoinTopListFragment)

    fun inject(coinInfoFragment: CoinInfoFragment)
}