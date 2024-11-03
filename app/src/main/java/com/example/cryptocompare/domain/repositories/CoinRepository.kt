package com.example.cryptocompare.domain.repositories

import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.entities.Currency

interface CoinRepository {
    suspend fun getCoinTopList(currency: Currency, limit: Int): List<CoinInfo>
    suspend fun getCoinInfo(currency: Currency, coinName: String): CoinInfo
}