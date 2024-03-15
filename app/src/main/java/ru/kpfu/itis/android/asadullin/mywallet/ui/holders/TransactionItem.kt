package ru.kpfu.itis.android.asadullin.mywallet.ui.holders

import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.model.TransactionCatalog

class TransactionItem(private val binding: ItemTransactionBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(transaction: TransactionCatalog.TransactionModel) {
        with(binding) {
            tvTransactionCategory.text = transaction.transactionCategory.toString()
            tvTransactionAmount.text = transaction.transactionAmount.toString()
            tvTransactionDate.text = transaction.transactionDate.toString()
            tvTransactionDescription.text = transaction.transactionDescription.orEmpty()
        }
    }
}