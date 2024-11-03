package com.example.cryptocompare.data.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoContainerDto(
    @SerializedName("RAW")
    @Expose
    val coinInfo: CoinInfoDto,
    @SerializedName("DISPLAY")
    @Expose
    val coinInfoDisplay: CoinInfoDto
)
