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

    fun onBind(transactionDomain: TransactionDomain) {
        with(binding) {
            tvTransactionCategory.text = transactionDomain.transactionCategory.toString()
            val formattedAmount = transactionDomain.transactionAmount.toString()
            val trimmedAmount = if (formattedAmount.length > 8) {
                formattedAmount.substring(0, 8) + "…"
            } else {
                formattedAmount
            }
            if (transactionDomain.isIncome) {
                tvTransactionAmount.text = trimmedAmount
            } else {
                tvTransactionAmount.text = "—${trimmedAmount}"
            }
            tvTransactionDescription.text = transactionDomain.transactionDescription.orEmpty()
            bgCategory.setBackgroundColor(Color.parseColor(TransactionCategoryType.getBackground(transactionDomain.transactionCategory)))
            ivCategoryImage.setImageResource(TransactionCategoryType.getDrawableId(transactionDomain.transactionCategory))
        }
    }
}