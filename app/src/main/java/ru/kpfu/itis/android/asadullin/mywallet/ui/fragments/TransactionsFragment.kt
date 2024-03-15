package ru.kpfu.itis.android.asadullin.mywallet.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.adapters.TransactionAdapter
import ru.kpfu.itis.android.asadullin.mywallet.databinding.FragmentTransactionsBinding
import ru.kpfu.itis.android.asadullin.mywallet.model.TransactionCatalog
import ru.kpfu.itis.android.asadullin.mywallet.model.enums.TransactionCategoryType
import java.sql.Date

class TransactionsFragment : Fragment(R.layout.fragment_transactions) {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding: FragmentTransactionsBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        with(binding) {
            val transactions : List<TransactionCatalog> = listOf(
                TransactionCatalog.TransactionModel(1, TransactionCategoryType.Food, "", true, 1.00, Date(System.currentTimeMillis()), ""),
            )


            rvTransactions.layoutManager = LinearLayoutManager(context)
            rvTransactions.adapter = TransactionAdapter(transactions)
        }
    }

}