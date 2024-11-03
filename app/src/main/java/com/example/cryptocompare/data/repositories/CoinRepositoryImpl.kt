package com.example.cryptocompare.data.repositories

import com.example.cryptocompare.data.mappers.CoinInfoMapper
import com.example.cryptocompare.data.network.ApiFactory
import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.entities.Currency
import com.example.cryptocompare.domain.repositories.CoinRepository

class CoinRepositoryImpl : CoinRepository {

    private val coinInfoMapper = CoinInfoMapper()

    override suspend fun getCoinInfoList(): List<CoinInfo> {
        return ApiFactory.apiService.getTopCoinsInfo(limit = 50)
            .coinTopListJsonContainer
            .mapNotNull { coinInfoMapper.mapCoinTopItemJsonContainerDtoToCoinInfoDto(it, Currency.USD) }
            .map { coinInfoMapper.mapDtoToEntity(it) }
    }

    override suspend fun getCoinPrice(): CoinInfo {
        TODO("Not yet implemented")
    }
}