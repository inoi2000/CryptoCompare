package com.example.cryptocompare.data.network

import com.example.cryptocompare.data.network.models.CoinInfoDto
import com.example.cryptocompare.data.network.models.CoinTopItemJsonContainerDto
import com.example.cryptocompare.domain.entities.Currency
import com.google.gson.Gson

class Parser {
    fun parseJsonToCoinInfoDto(
        coinTopItemJsonContainerDto: CoinTopItemJsonContainerDto,
        currency: Currency
    ): CoinInfoDto? {
        val jsonObject = coinTopItemJsonContainerDto.json
        jsonObject?.let {
            return Gson().fromJson(
                it.getAsJsonObject(currency.name),
                CoinInfoDto::class.java
            )
        }
        return null
    }
}