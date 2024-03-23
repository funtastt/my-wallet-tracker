package ru.kpfu.itis.android.asadullin.mywallet.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.databinding.FragmentTransactionsBinding
import ru.kpfu.itis.android.asadullin.mywallet.di.ServiceLocator
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import ru.kpfu.itis.android.asadullin.mywallet.presentation.adapters.TransactionAdapter
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
        loadTransactions()
    }

    private fun initViews() {
        binding.rvTransactions.layoutManager = LinearLayoutManager(context)
    }

    private fun loadTransactions() {
        lifecycleScope.launch {
            val transactionDomains = ServiceLocator.getAllTransactionsUseCase.execute()
            binding.rvTransactions.adapter = TransactionAdapter(transactionDomains)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}