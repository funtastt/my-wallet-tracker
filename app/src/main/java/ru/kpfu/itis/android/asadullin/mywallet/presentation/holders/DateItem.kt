package ru.kpfu.itis.android.asadullin.mywallet.presentation.holders

import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemTransactionDateBinding

class DateItem(private val binding: ItemTransactionDateBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(date: String) {
        binding.tvTransactionDate.text = date
    }
}