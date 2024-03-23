package ru.kpfu.itis.android.asadullin.mywallet.presentation.holders

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemCategoryButtonBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.CategoryDomain
import ru.kpfu.itis.android.asadullin.mywallet.presentation.fragments.AddTransactionFragment

class CategoryItem(private val binding: ItemCategoryButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private lateinit var childFragmentManager: FragmentManager
    fun onBind(categoryDomain: CategoryDomain, childFragmentManager: FragmentManager) {
        this.childFragmentManager = childFragmentManager
        with(binding) {
            tvItemCategoryTitle.text = categoryDomain.category.name
            tvItemCategoryAmount.text = categoryDomain.amount.toString()
            ibCategory.setImageDrawable(root.resources.getDrawable(categoryDomain.category.drawableId))
            vCategoryBackground.setBackgroundColor(Color.parseColor(categoryDomain.category.background))
            root.setOnClickListener {
                navigateToAddTransaction(categoryDomain.category.name)
            }
        }
    }

    private fun navigateToAddTransaction(category: String) {
        val bundle = Bundle().apply {
            putString("category", category)
        }
        val dialogFragment = AddTransactionFragment()
        dialogFragment.arguments = bundle
        dialogFragment.show(childFragmentManager, "add_transaction_dialog")
    }
}