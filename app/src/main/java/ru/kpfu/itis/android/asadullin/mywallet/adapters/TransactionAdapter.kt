package ru.kpfu.itis.android.asadullin.mywallet.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.model.TransactionCatalog
import ru.kpfu.itis.android.asadullin.mywallet.ui.holders.TransactionItem

class TransactionAdapter(private val transactions: List<TransactionCatalog>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TransactionItem(
            binding = ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransactionItem -> {
                holder.onBind(transactions[position] as TransactionCatalog.TransactionModel)
            }
        }
    }

    override fun getItemCount(): Int = transactions.size
}