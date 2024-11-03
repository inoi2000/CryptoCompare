package com.example.cryptocompare.data.network.models

import com.google.gson.JsonArray
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinTopListResponseDto(
    @SerializedName("Data")
    @Expose
    val coinTopListJsonArray: JsonArray
)
