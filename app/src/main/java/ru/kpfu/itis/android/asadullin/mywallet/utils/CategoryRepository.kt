package ru.kpfu.itis.android.asadullin.mywallet.utils

import ru.kpfu.itis.android.asadullin.mywallet.R
import ru.kpfu.itis.android.asadullin.mywallet.model.TransactionCategory
import ru.kpfu.itis.android.asadullin.mywallet.model.enums.TransactionCategoryType

object CategoryRepository {
    val categories = listOf(
        TransactionCategory(1000.0, TransactionCategoryType.Food, true, "#fab858", R.drawable.food),
        TransactionCategory(999.0, TransactionCategoryType.Clothes, true, "#dd497b", R.drawable.clothes),
        TransactionCategory(777.0, TransactionCategoryType.Gifts, true, "#fe1b50", R.drawable.gifts),
        TransactionCategory(666.0, TransactionCategoryType.Health, true, "#bbc435", R.drawable.health),
        TransactionCategory(555.0, TransactionCategoryType.Investments, true, "#499c4a", R.drawable.investments),
        TransactionCategory(789.0, TransactionCategoryType.Other, true, "#218fe8", R.drawable.other),
        TransactionCategory(123.0, TransactionCategoryType.Relax, true, "#f66e0a", R.drawable.relax),
        TransactionCategory(456.0, TransactionCategoryType.Tech, true, "#292929", R.drawable.tech),
        TransactionCategory(987.0, TransactionCategoryType.Transport, true, "#f7db02", R.drawable.transport),
    )
}