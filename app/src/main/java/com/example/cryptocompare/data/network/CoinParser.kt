package com.example.cryptocompare.data.network

import com.example.cryptocompare.data.network.models.CoinInfoDto
import com.example.cryptocompare.domain.entities.Currency
import com.google.gson.Gson
import com.google.gson.JsonArray

class CoinParser {
    companion object {
        private const val COIN_INFO_SERIALIZED_NAME = "RAW"
    }

    fun parseJsonToCoinInfoDtoList(
        coinTopListJsonArray: JsonArray,
        currency: Currency
    ): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        for (jsonElement in coinTopListJsonArray) {
            jsonElement.getAsJsonObject()?.let { jsonObject ->
                jsonObject.getAsJsonObject(COIN_INFO_SERIALIZED_NAME)?.let { jsonContainer ->
                    jsonContainer.getAsJsonObject(currency.name)?.let { jsonCoinInfoDto ->
                        val coinInfoDto = Gson().fromJson(
                            jsonCoinInfoDto,
                            CoinInfoDto::class.java
                        )
                        result.add(coinInfoDto)
                    }
                }
            }
        }
        return result
    }
}