package com.example.cryptocompare.presentation.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocompare.R
import com.example.cryptocompare.databinding.ItemCoinInfoBinding
import com.example.cryptocompare.domain.entities.CoinInfo
import com.squareup.picasso.Picasso

class CoinInfoAdapter(
    private val context: Context,
    private val onCoinClick: (CoinInfo) -> Unit
) : ListAdapter<CoinInfo, CoinInfoAdapter.CoinInfoViewHolder>(CoinDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCoinInfoBinding.inflate(inflater, parent, false)
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            with(coin) {
                val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                tvSymbols.text = String.format(symbolsTemplate, name, comparisonCurrency)
                tvPrice.text = price
                tvLastUpdate.text = String.format(lastUpdateTemplate, lastUpdate)
                Picasso.get().load(imageUrl).into(holder.binding.ivLogoCoin)
                root.setOnClickListener {
                    onCoinClick(this)
                }
            }
        }
    }

    class CoinInfoViewHolder(
        val binding: ItemCoinInfoBinding
    ) : RecyclerView.ViewHolder(binding.root)
}