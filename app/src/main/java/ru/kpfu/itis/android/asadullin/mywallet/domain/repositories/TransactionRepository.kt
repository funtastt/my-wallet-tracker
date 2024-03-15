package ru.kpfu.itis.android.asadullin.mywallet.domain.repositories

import ru.kpfu.itis.android.asadullin.mywallet.data.local.entity.TransactionEntity
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain

interface TransactionRepository {
    suspend fun saveTransaction(transactionDomain: TransactionDomain)
    suspend fun getAllTransactions() : List<TransactionEntity>
}