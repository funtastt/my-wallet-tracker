package ru.kpfu.itis.android.asadullin.mywallet.domain.model

import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType

data class CategoryDomain(
    var amount: Double,
    var category: TransactionCategoryType,
    var isIncome: Boolean,
)