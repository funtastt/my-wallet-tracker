package ru.kpfu.itis.android.asadullin.mywallet.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.databinding.FragmentAddTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.di.ServiceLocator
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import java.sql.Date

class AddTransactionFragment : Fragment(R.layout.fragment_add_transaction) {
    private var _binding: FragmentAddTransactionBinding? = null
    private val binding: FragmentAddTransactionBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTransactionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        initListeners()
    }

    private fun initViews() {
        with(binding) {
            val categories = TransactionCategoryType.values().map { it.name }.toTypedArray()
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCategory.adapter = adapter
        }
    }

    private fun initListeners() {
        with(binding) {
            btnContinue.setOnClickListener {
                saveTransaction()
            }
        }
    }

    private fun saveTransaction() {
        with(binding) {
            val amount = tietAmount.text.toString()
            val category = spinnerCategory.selectedItem.toString()
            val description = tietDescription.text.toString()

            if (amount.isNotEmpty() && category.isNotEmpty()) {
                val transaction = TransactionDomain(
                    transactionCategory = TransactionCategoryType.valueOf(category),
                    transactionDescription = description,
                    isIncome = true, // Примерное значение, вам нужно будет определить, является ли транзакция доходом или расходом
                    transactionAmount = amount.toDouble(),
                    transactionDate = Date(System.currentTimeMillis()) // Текущая дата
                )

                lifecycleScope.launch {
                    ServiceLocator.saveTransactionUseCase.execute(transaction)
                    Snackbar.make(requireView(), "Sucksess!", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                Snackbar.make(requireView(), "Please fill all fields", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}