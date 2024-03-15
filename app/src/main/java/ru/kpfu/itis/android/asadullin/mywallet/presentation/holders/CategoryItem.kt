package ru.kpfu.itis.android.asadullin.mywallet.presentation.holders

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemCategoryButtonBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.CategoryDomain

class CategoryItem(private val binding: ItemCategoryButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(categoryDomain: CategoryDomain) {
        with(binding) {
            tvItemCategoryTitle.text = categoryDomain.category.name
            tvItemCategoryAmount.text = categoryDomain.amount.toString()
            ibCategory.setImageDrawable(root.resources.getDrawable(categoryDomain.category.drawableId))
            vCategoryBackground.setBackgroundColor(Color.parseColor(categoryDomain.category.background))
        }
    }
}