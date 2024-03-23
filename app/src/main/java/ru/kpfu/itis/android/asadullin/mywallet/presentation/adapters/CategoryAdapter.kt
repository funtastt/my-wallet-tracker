package ru.kpfu.itis.android.asadullin.mywallet.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.android.asadullin.mywallet.databinding.ItemCategoryButtonBinding
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.CategoryDomain
import ru.kpfu.itis.android.asadullin.mywallet.presentation.holders.CategoryItem

class CategoryAdapter(private val categories: List<CategoryDomain>, private val childFragmentManager: FragmentManager) :
    RecyclerView.Adapter<CategoryItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryItem(
        binding = ItemCategoryButtonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: CategoryItem, position: Int) {
        holder.onBind(categories[position], childFragmentManager = childFragmentManager)
    }

    override fun getItemCount(): Int = categories.size
}