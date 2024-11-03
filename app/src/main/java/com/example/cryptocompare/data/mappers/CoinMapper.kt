package com.example.cryptocompare.data.mappers

import com.example.cryptocompare.data.database.models.CoinInfoDbModel
import com.example.cryptocompare.data.network.models.CoinInfoDto
import com.example.cryptocompare.data.network.models.CoinTopItemJsonContainerDto
import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.entities.Currency
import com.google.gson.Gson

class CoinMapper {
    fun mapEntityToDbModel(entity: CoinInfo): CoinInfoDbModel =
        CoinInfoDbModel(
            name = entity.name,
            comparisonCurrency = entity.comparisonCurrency,
            price = entity.price,
            imageUrl = entity.imageUrl,
            lastUpdate = entity.lastUpdate,
            lastVolume = entity.lastVolume,
            lastVolumeTo = entity.lastVolumeTo,
            lastTradeId = entity.lastTradeId,
            flags = entity.flags,
            type = entity.type,
            market = entity.market,
            volumeDay = entity.volumeDay,
            volumeDayTo = entity.volumeDayTo,
            volume24Hour = entity.volume24Hour,
            volume24HourTo = entity.volumeHourTo,
            openDay = entity.openDay,
            highDay = entity.highDay,
            lowDay = entity.lowDay,
            open24Hour = entity.open24Hour,
            high24Hour = entity.high24Hour,
            low24Hour = entity.low24Hour,
            lastMarket = entity.lastMarket,
            volumeHour = entity.volumeHour,
            volumeHourTo = entity.volumeHourTo,
            openHour = entity.openHour,
            highHour = entity.highHour,
            lowHour = entity.lowHour,
            topTierVolume24Hour = entity.topTierVolume24Hour,
            topTierVolume24HourTo = entity.topTierVolume24HourTo,
            change24Hour = entity.change24Hour,
            changePCT24Hour = entity.changePCT24Hour,
            changeDay = entity.changeDay,
            changePCTDay = entity.changePCTDay,
            supply = entity.supply,
            mktCap = entity.mktCap,
            totalVolume24Hour = entity.totalVolume24Hour,
            totalVolume24HourTo = entity.totalVolume24HourTo,
            totalTopTierVolume24Hour = entity.totalTopTierVolume24Hour,
            totalTopTierVolume24HourTo = entity.totalTopTierVolume24HourTo
        )

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel): CoinInfo =
        CoinInfo(
            name = dbModel.name,
            comparisonCurrency = dbModel.comparisonCurrency,
            price = dbModel.price,
            imageUrl = dbModel.imageUrl,
            lastUpdate = dbModel.lastUpdate,
            lastVolume = dbModel.lastVolume,
            lastVolumeTo = dbModel.lastVolumeTo,
            lastTradeId = dbModel.lastTradeId,
            flags = dbModel.flags,
            type = dbModel.type,
            market = dbModel.market,
            volumeDay = dbModel.volumeDay,
            volumeDayTo = dbModel.volumeDayTo,
            volume24Hour = dbModel.volume24Hour,
            volume24HourTo = dbModel.volumeHourTo,
            openDay = dbModel.openDay,
            highDay = dbModel.highDay,
            lowDay = dbModel.lowDay,
            open24Hour = dbModel.open24Hour,
            high24Hour = dbModel.high24Hour,
            low24Hour = dbModel.low24Hour,
            lastMarket = dbModel.lastMarket,
            volumeHour = dbModel.volumeHour,
            volumeHourTo = dbModel.volumeHourTo,
            openHour = dbModel.openHour,
            highHour = dbModel.highHour,
            lowHour = dbModel.lowHour,
            topTierVolume24Hour = dbModel.topTierVolume24Hour,
            topTierVolume24HourTo = dbModel.topTierVolume24HourTo,
            change24Hour = dbModel.change24Hour,
            changePCT24Hour = dbModel.changePCT24Hour,
            changeDay = dbModel.changeDay,
            changePCTDay = dbModel.changePCTDay,
            supply = dbModel.supply,
            mktCap = dbModel.mktCap,
            totalVolume24Hour = dbModel.totalVolume24Hour,
            totalVolume24HourTo = dbModel.totalVolume24HourTo,
            totalTopTierVolume24Hour = dbModel.totalTopTierVolume24Hour,
            totalTopTierVolume24HourTo = dbModel.totalTopTierVolume24HourTo
        )

    fun mapDtoToEntity(dto: CoinInfoDto): CoinInfo =
        CoinInfo(
            name = dto.name,
            comparisonCurrency = dto.comparisonCurrency,
            price = dto.price,
            imageUrl = dto.getFullImageUrl(),
            lastUpdate = dto.getFormattedTime(),
            lastVolume = dto.lastVolume,
            lastVolumeTo = dto.lastVolumeTo,
            lastTradeId = dto.lastTradeId,
            flags = dto.flags,
            type = dto.type,
            market = dto.market,
            volumeDay = dto.volumeDay,
            volumeDayTo = dto.volumeDayTo,
            volume24Hour = dto.volume24Hour,
            volume24HourTo = dto.volumeHourTo,
            openDay = dto.openDay,
            highDay = dto.highDay,
            lowDay = dto.lowDay,
            open24Hour = dto.open24Hour,
            high24Hour = dto.high24Hour,
            low24Hour = dto.low24Hour,
            lastMarket = dto.lastMarket,
            volumeHour = dto.volumeHour,
            volumeHourTo = dto.volumeHourTo,
            openHour = dto.openHour,
            highHour = dto.highHour,
            lowHour = dto.lowHour,
            topTierVolume24Hour = dto.topTierVolume24Hour,
            topTierVolume24HourTo = dto.topTierVolume24HourTo,
            change24Hour = dto.change24Hour,
            changePCT24Hour = dto.changePCT24Hour,
            changeDay = dto.changeDay,
            changePCTDay = dto.changePCTDay,
            supply = dto.supply,
            mktCap = dto.mktCap,
            totalVolume24Hour = dto.totalVolume24Hour,
            totalVolume24HourTo = dto.totalVolume24HourTo,
            totalTopTierVolume24Hour = dto.totalTopTierVolume24Hour,
            totalTopTierVolume24HourTo = dto.totalTopTierVolume24HourTo
        )

    fun mapCoinTopItemJsonContainerDtoToCoinInfoDto(
        coinTopItemJsonContainerDto: CoinTopItemJsonContainerDto,
        currency: Currency ): CoinInfoDto? {
        val jsonObject = coinTopItemJsonContainerDto.json
        jsonObject?.let {
            return Gson().fromJson(
                it.getAsJsonObject(currency.name),
                CoinInfoDto::class.java)
        }
        return null
    }
}