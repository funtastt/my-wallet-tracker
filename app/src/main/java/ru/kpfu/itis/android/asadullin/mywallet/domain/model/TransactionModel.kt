package ru.kpfu.itis.android.asadullin.mywallet.domain.model

import ru.kpfu.itis.android.asadullin.mywallet.data.local.entity.TransactionEntity
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import java.sql.Date

data class TransactionModel(
    val transactionId: Int? = null,
    val transactionCategory: TransactionCategoryType,
    val transactionDescription: String?,
    val isIncome: Boolean,
    val transactionAmount: Double,
    val transactionDate: Date,
    val transactionAttachmentURL: String?,
) {
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