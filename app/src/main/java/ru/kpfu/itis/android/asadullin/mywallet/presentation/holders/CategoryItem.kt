package ru.kpfu.itis.android.asadullin.mywallet.presentation.holders

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemCategoryButtonBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionCategory

class CategoryItem(private val binding: ItemCategoryButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(transactionCategory: TransactionCategory) {
        with(binding) {
            tvItemCategoryTitle.text = transactionCategory.category.name
            tvItemCategoryAmount.text = transactionCategory.amount.toString()
            ibCategory.setImageDrawable(root.resources.getDrawable(transactionCategory.categoryImageId!!))
            vCategoryBackground.setBackgroundColor(Color.parseColor(transactionCategory.backgroundColor))
        }
    }
}