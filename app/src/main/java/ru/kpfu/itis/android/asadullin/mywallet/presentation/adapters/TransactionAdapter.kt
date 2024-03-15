package ru.kpfu.itis.android.asadullin.mywallet.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionModel
import ru.kpfu.itis.android.asadullin.mywallet.presentation.holders.TransactionItem

class TransactionAdapter(private val transactions: List<TransactionModel>) :
    RecyclerView.Adapter<TransactionItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionItem {
        return TransactionItem(
            binding = ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }



    override fun onBindViewHolder(holder: TransactionItem, position: Int) {
        holder.onBind(transactions[position])
    }

    override fun getItemCount(): Int = transactions.size
}