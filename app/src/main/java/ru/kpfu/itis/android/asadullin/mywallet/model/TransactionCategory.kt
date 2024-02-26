package ru.kpfu.itis.android.asadullin.mywallet.model

import android.graphics.drawable.Drawable
import ru.kpfu.itis.android.asadullin.mywallet.model.enums.TransactionCategoryType

data class TransactionCategory(
    var amount: Double,
    var category: TransactionCategoryType,
    var isIncome: Boolean,
    var backgroundColor: String,
    var categoryImageId: Int?
)