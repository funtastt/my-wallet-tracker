package ru.kpfu.itis.android.asadullin.mywallet.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemCategoryButtonBinding
import ru.kpfu.itis.android.asadullin.mywallet.model.TransactionCategory
import ru.kpfu.itis.android.asadullin.mywallet.model.enums.TransactionCategoryType
import ru.kpfu.itis.android.asadullin.mywallet.ui.holders.CategoryItem

class CategoryAdapter(private val categories: List<TransactionCategory>) :
    RecyclerView.Adapter<CategoryItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryItem(
        binding = ItemCategoryButtonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: CategoryItem, position: Int) {
        holder.onBind(categories[position])
    }

    override fun getItemCount(): Int = categories.size
}