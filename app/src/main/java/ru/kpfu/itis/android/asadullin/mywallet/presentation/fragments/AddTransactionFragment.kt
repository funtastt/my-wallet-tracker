package ru.kpfu.itis.android.asadullin.mywallet.presentation.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.databinding.FragmentAddTransactionBinding
import ru.kpfu.itis.android.asadullin.mywallet.di.ServiceLocator
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import java.sql.Date

class AddTransactionFragment : DialogFragment() {
    private var _binding: FragmentAddTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = FragmentAddTransactionBinding.inflate(LayoutInflater.from(context))

        initViews()
        initListeners()

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
    }

    private fun initViews() {
        with(binding) {
            val categories = TransactionCategoryType.values().map { it.name }.toTypedArray()
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCategory.adapter = adapter

            arguments?.let { bundle ->
                val category = bundle.getString("category")
                val categoryIndex = adapter.getPosition(category)
                if (categoryIndex >= 0) {
                    spinnerCategory.setSelection(categoryIndex)
                }
            }
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
                    isIncome = true,
                    transactionAmount = amount.toDouble(),
                    transactionDate = Date(System.currentTimeMillis())
                )

                lifecycleScope.launch {
                    ServiceLocator.saveTransactionUseCase.execute(transaction)
                    Snackbar.make(requireView(), "Success!", Snackbar.LENGTH_SHORT).show()
                    dismiss() // Dismiss the dialog after successful transaction
                }
            } else {
                Snackbar.make(requireView(), "Please fill all fields", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}