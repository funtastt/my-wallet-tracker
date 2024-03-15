package ru.kpfu.itis.android.asadullin.mywallet.presentation.holders

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import java.text.SimpleDateFormat
import java.util.Locale

class TransactionItem(private val binding: ItemTransactionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val dateFormat = SimpleDateFormat("dd.MM.yyyy, HH:mm", Locale.getDefault())

    fun onBind(transactionDomain: TransactionDomain) {
        with(binding) {
            tvTransactionCategory.text = transactionDomain.transactionCategory.toString()
            tvTransactionAmount.text = transactionDomain.transactionAmount.toString()
            tvTransactionDate.text = dateFormat.format(transactionDomain.transactionDate)
            tvTransactionDescription.text = transactionDomain.transactionDescription.orEmpty()
            bgCategory.setBackgroundColor(Color.parseColor(TransactionCategoryType.getBackground(transactionDomain.transactionCategory)))
            ivCategoryImage.setImageResource(TransactionCategoryType.getDrawableId(transactionDomain.transactionCategory))
        }
    }
}