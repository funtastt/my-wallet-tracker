package ru.kpfu.itis.android.asadullin.mywallet.domain.model

import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import java.util.Date

data class TransactionDomain(
    val transactionId: Int? = null,
    val transactionCategory: TransactionCategoryType,
    val transactionDescription: String?,
    val isIncome: Boolean,
    val transactionAmount: Double,
    val transactionDate: Date,
)