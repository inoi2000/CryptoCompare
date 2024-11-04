package com.example.cryptocompare.presentation.views.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptocompare.domain.entities.CoinInfo

object CoinDiffItemCallback : DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean =
        oldItem == newItem

}