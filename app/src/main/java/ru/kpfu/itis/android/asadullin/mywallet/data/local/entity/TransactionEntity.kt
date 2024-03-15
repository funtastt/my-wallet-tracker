package ru.kpfu.itis.android.asadullin.mywallet.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "transaction_id") val transactionId: Int = 0,
    @ColumnInfo(name = "transaction_category") val transactionCategory: String,
    @ColumnInfo(name = "transaction_description") val transactionDescription : String?,
    @ColumnInfo(name = "is_income") val isIncome : Boolean,
    @ColumnInfo(name = "transaction_amount") val transactionAmount : Double,
    @ColumnInfo(name = "transaction_date") val transactionDate : Long,
)