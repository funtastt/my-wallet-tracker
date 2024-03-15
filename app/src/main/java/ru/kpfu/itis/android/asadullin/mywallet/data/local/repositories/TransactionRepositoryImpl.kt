package ru.kpfu.itis.android.asadullin.mywallet.data.local.repositories

import ru.kpfu.itis.android.asadullin.mywallet.data.local.dao.TransactionDao
import ru.kpfu.itis.android.asadullin.mywallet.data.local.entity.TransactionEntity
import ru.kpfu.itis.android.asadullin.mywallet.data.local.mappers.TransactionMapper
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.repositories.TransactionRepository

class TransactionRepositoryImpl(private val transactionDao: TransactionDao) :
    TransactionRepository {
    override suspend fun saveTransaction(transactionDomain: TransactionDomain) {
        val transactionEntity = TransactionMapper.mapToEntity(transactionDomain)
        transactionDao.insertTransaction(transactionEntity)
    }

    override suspend fun getAllTransactions() = transactionDao.getAllTransactions()
}