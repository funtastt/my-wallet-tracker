package ru.kpfu.itis.android.asadullin.mywallet.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionDateBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDate
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.Transaction
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionModel
import ru.kpfu.itis.android.asadullin.mywallet.presentation.holders.DateItem
import ru.kpfu.itis.android.asadullin.mywallet.presentation.holders.TransactionItem

class TransactionAdapter(private val items: List<TransactionModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TRANSACTION -> TransactionItem(ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_DATE -> DateItem(ItemTransactionDateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransactionItem -> holder.onBind((items[position] as Transaction).transaction)
            is DateItem -> holder.onBind((items[position] as TransactionDate).date)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Transaction -> TYPE_TRANSACTION
            is TransactionDate -> TYPE_DATE
        }
    }

    companion object {
        private const val TYPE_TRANSACTION = 0
        private const val TYPE_DATE = 1
    }
}