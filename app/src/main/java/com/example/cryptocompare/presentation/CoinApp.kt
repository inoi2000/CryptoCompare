package com.example.cryptocompare.presentation

import android.app.Application
import com.example.cryptocompare.di.DaggerApplicationComponent

class CoinApp: Application() {
    val component by lazy {
        DaggerApplicationComponent.create()
    }
}