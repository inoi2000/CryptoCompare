package com.example.cryptocompare.data.repositories

import com.example.cryptocompare.data.mappers.CoinMapper
import com.example.cryptocompare.data.network.ApiFactory
import com.example.cryptocompare.data.network.CoinParser
import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.entities.Currency
import com.example.cryptocompare.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiFactory: ApiFactory,
    private val coinMapper: CoinMapper,
    private val coinParser: CoinParser
) : CoinRepository {

    override suspend fun getCoinTopList(
        currency: Currency,
        limit: Int
    ): List<CoinInfo> {
        val response =
            apiFactory.apiService.getTopCoinsInfo(limit = limit, tSym = currency.name)
        return coinParser.parseJsonArrayToCoinInfoDtoList(
            response.coinTopListJsonArray,
            currency
        ).map { coinMapper.mapDtoToEntity(it) }
    }

    override suspend fun getCoinInfo(currency: Currency, coinName: String): CoinInfo {
        val response =
            apiFactory.apiService.getFullCoinInfo(fSyms = coinName, tSyms = currency.name)
        val coinInfoDto =
            coinParser.parseJsonToCoinInfoDto(response.coinInfoJson, currency, coinName)
        return coinMapper.mapDtoToEntity(coinInfoDto)
    }
}