package ru.kpfu.itis.android.asadullin.mywallet.presentation.holders

import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionModel

class TransactionItem(private val binding: ItemTransactionBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(transaction: TransactionModel) {
        with(binding) {
            tvTransactionCategory.text = transaction.transactionCategory.toString()
            tvTransactionAmount.text = transaction.transactionAmount.toString()
            tvTransactionDate.text = transaction.transactionDate.toString()
            tvTransactionDescription.text = transaction.transactionDescription.orEmpty()
        }
    }
}