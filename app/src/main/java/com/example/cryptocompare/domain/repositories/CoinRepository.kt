package com.example.cryptocompare.domain.repositories

import com.example.cryptocompare.domain.entities.CoinInfo

interface CoinRepository {
    suspend fun getCoinInfoList(): List<CoinInfo>
    suspend fun getCoinPrice(): CoinInfo
}