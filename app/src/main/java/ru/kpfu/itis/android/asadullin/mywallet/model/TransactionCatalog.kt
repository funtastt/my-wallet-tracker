package ru.kpfu.itis.android.asadullin.mywallet.model

import ru.kpfu.itis.android.asadullin.mywallet.data.db.entity.TransactionEntity
import ru.kpfu.itis.android.asadullin.mywallet.model.enums.TransactionCategoryType
import java.sql.Date

sealed class TransactionCatalog {
    data class TransactionDate(
        val date: Date
    ) : TransactionCatalog()

    data class TransactionModel(
        val transactionId: Int? = null,
        val transactionCategory: TransactionCategoryType,
        val transactionDescription: String?,
        val isIncome: Boolean,
        val transactionAmount: Double,
        val transactionDate: Date,
        val transactionAttachmentURL: String?,
    ) : TransactionCatalog() {
        companion object {
            fun fromTransactionEntity(transactionEntity: TransactionEntity) = TransactionModel(
                transactionId = transactionEntity.transactionId,
                transactionCategory = TransactionCategoryType.valueOf(transactionEntity.transactionCategory),
                transactionDescription = transactionEntity.transactionDescription,
                isIncome = transactionEntity.isIncome,
                transactionAmount = transactionEntity.transactionAmount,
                transactionDate = transactionEntity.transactionDate,
                transactionAttachmentURL = transactionEntity.transactionAttachmentURL
            )
        }
    }
}