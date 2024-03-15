package ru.kpfu.itis.android.asadullin.mywallet.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.android.asadullin.mywallet.data.local.mappers.TransactionMapper
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.repositories.CategoryRepository
import ru.kpfu.itis.android.asadullin.mywallet.domain.repositories.TransactionRepository

class CalculateExpensesUseCase(
    private val categoryRepository: CategoryRepository,
    private val dispatcher: CoroutineDispatcher,
) {
    suspend fun execute(category: String) : Double {
        with(dispatcher) {
            return categoryRepository.calculateExpensesByCategory(category)
        }
    }
}