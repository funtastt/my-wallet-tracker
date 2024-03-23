package ru.kpfu.itis.android.asadullin.mywallet.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.repositories.TransactionRepository

class SaveTransactionUseCase(
    private val transactionRepository: TransactionRepository,
    private val dispatcher: CoroutineDispatcher,
) {
    suspend fun execute(transactionDomain: TransactionDomain) {
        with(dispatcher) {
            transactionRepository.saveTransaction(transactionDomain)
        }
    }
}