package com.example.cryptocompare.presentation.views.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptocompare.domain.entities.CoinInfo

class CoinDiffItemCallback: DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        TODO("Not yet implemented")
    }

}