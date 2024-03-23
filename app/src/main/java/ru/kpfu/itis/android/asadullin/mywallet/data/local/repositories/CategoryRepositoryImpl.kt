package ru.kpfu.itis.android.asadullin.mywallet.data.local.repositories

import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.data.local.dao.TransactionDao
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.CategoryDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import ru.kpfu.itis.android.asadullin.mywallet.domain.repositories.CategoryRepository

class CategoryRepositoryImpl(private val transactionDao: TransactionDao) : CategoryRepository {

    override suspend fun calculateExpensesByCategory(category: String) =
        transactionDao.getTransactionsByCategory(category).map { it.transactionAmount }.sum()

}