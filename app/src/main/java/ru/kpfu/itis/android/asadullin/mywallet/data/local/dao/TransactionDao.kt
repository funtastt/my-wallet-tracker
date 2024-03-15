package ru.kpfu.itis.android.asadullin.mywallet.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.kpfu.itis.android.asadullin.mywallet.data.local.entity.TransactionEntity

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transaction: TransactionEntity)

    @Query("SELECT * FROM transactions")
    suspend fun getAllTransactions(): List<TransactionEntity>

    @Query("SELECT * FROM transactions WHERE transaction_category = :category")
    suspend fun getTransactionsByCategory(category: String): List<TransactionEntity>
}