package com.example.cryptocompare.data.repositories

import com.example.cryptocompare.data.mappers.CoinMapper
import com.example.cryptocompare.data.network.ApiFactory
import com.example.cryptocompare.data.network.CoinParser
import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.entities.Currency
import com.example.cryptocompare.domain.repositories.CoinRepository

class CoinRepositoryImpl : CoinRepository {

    private val coinMapper = CoinMapper()
    private val coinParser = CoinParser()

    override suspend fun getCoinTopList(
        currency: Currency,
        limit: Int
    ): List<CoinInfo> {
        val response = ApiFactory.apiService.getTopCoinsInfo(limit = limit)
        return coinParser.parseJsonToCoinInfoDtoList(
            response.coinTopListJsonArray,
            currency
        ).map { coinMapper.mapDtoToEntity(it) }
    }

    override suspend fun getCoinInfo(currency: Currency, coinName: String): CoinInfo {
        TODO("Not yet implemented")
    }
}