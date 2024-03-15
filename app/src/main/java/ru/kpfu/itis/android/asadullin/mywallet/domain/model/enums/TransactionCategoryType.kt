package ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums

import ru.kpfu.itis.android.asadullin.mywallet.R

enum class TransactionCategoryType(val drawableId: Int, val background: String, val isIncome : Boolean) {
    Food(R.drawable.food, "#fab858", false),
    Gifts(R.drawable.gifts, "#fe1b50", false),
    Relax(R.drawable.relax, "#f66e0a", false),
    Transport(R.drawable.transport, "#f7db02", false),
    Clothes(R.drawable.clothes, "#dd497b", false),
    Investments(R.drawable.investments, "#499c4a", false),
    Tech(R.drawable.tech, "#292929", false),
    Health(R.drawable.health, "#bbc435", false),
    Job(R.drawable.job, "#0e8d85", true),
    Passive(R.drawable.passive_income, "#6673c1", true),
    OtherIncome(R.drawable.other, "#35c6d7", true),
    OtherExpense(R.drawable.other, "#218fe8", false);

    companion object {
        fun getDrawableId(category: TransactionCategoryType) = category.drawableId

        fun getBackground(category: TransactionCategoryType) = category.background

        fun isIncome(category: TransactionCategoryType) = category.isIncome

    }
}