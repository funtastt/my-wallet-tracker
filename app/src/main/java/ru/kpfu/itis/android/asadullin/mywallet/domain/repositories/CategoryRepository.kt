package ru.kpfu.itis.android.asadullin.mywallet.domain.repositories

interface CategoryRepository {
    suspend fun calculateExpensesByCategory(category: String) : Double
}