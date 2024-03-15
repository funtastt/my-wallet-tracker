package ru.kpfu.itis.android.asadullin.mywallet.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionModel
import java.sql.Date

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "transaction_id") val transactionId: Int = 0,
    @ColumnInfo(name = "transaction_category") val transactionCategory: String,
    @ColumnInfo(name = "transaction_description") val transactionDescription : String?,
    @ColumnInfo(name = "is_income") val isIncome : Boolean,
    @ColumnInfo(name = "transaction_amount") val transactionAmount : Double,
    @ColumnInfo(name = "transaction_date") val transactionDate : Date,
    @ColumnInfo(name = "transaction_attachment") val transactionAttachmentURL : String?,
) {
    companion object {
        fun fromTransactionModel(transactionModel: TransactionModel) = TransactionEntity(
            transactionCategory = transactionModel.transactionCategory.toString(),
            transactionDescription = transactionModel.transactionDescription,
            isIncome = transactionModel.isIncome,
            transactionAmount = transactionModel.transactionAmount,
            transactionDate = transactionModel.transactionDate,
            transactionAttachmentURL = transactionModel.transactionAttachmentURL
        )
    }
}