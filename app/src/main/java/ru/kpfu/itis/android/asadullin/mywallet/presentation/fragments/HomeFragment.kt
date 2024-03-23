package ru.kpfu.itis.android.asadullin.mywallet.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.launch
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.databinding.FragmentHomeBinding
import ru.kpfu.itis.android.asadullin.mywallet.di.ServiceLocator
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.CategoryDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import ru.kpfu.itis.android.asadullin.mywallet.presentation.adapters.CategoryAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val expenseCategories = mutableListOf<CategoryDomain>()
    private val incomeCategories = mutableListOf<CategoryDomain>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        expenseCategories.clear()
        incomeCategories.clear()

        var expenseSum = 0.0
        var incomeSum = 0.0

        lifecycleScope.launch {
            for (category in TransactionCategoryType.values()) {
                val amount = ServiceLocator.calculateExpensesUseCase.execute(category.toString())
                val isIncome = TransactionCategoryType.isIncome(category)

                if (isIncome) {
                    incomeCategories.add(CategoryDomain(amount, category, true))
                    incomeSum += amount
                } else {
                    expenseCategories.add(CategoryDomain(amount, category, false))
                    expenseSum += amount
                }
            }

            with(binding) {
                rvCategories.layoutManager = GridLayoutManager(activity, 2)
                rvCategories.adapter = CategoryAdapter(expenseCategories, childFragmentManager)

                bgHomeIncome.setOnClickListener {
                    rvCategories.adapter = CategoryAdapter(incomeCategories, childFragmentManager)
                }
                bgHomeExpense.setOnClickListener {
                    rvCategories.adapter = CategoryAdapter(expenseCategories, childFragmentManager)
                }

                tvIncomeAmount.text = incomeSum.toString()
                tvExpenseAmount.text = expenseSum.toString()
            }
        }
    }

}