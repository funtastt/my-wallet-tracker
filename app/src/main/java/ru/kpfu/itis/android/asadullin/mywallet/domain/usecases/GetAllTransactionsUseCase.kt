package ru.kpfu.itis.android.asadullin.mywallet.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import ru.kpfu.itis.android.asadullin.mywallet.data.local.mappers.TransactionMapper
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.repositories.TransactionRepository

class GetAllTransactionsUseCase(
    private val transactionRepository: TransactionRepository,
    private val dispatcher: CoroutineDispatcher,
) {
    suspend fun execute() : List<TransactionDomain> {
        with(dispatcher) {
            val transactionEntities = transactionRepository.getAllTransactions()
            return transactionEntities.map { TransactionMapper.mapToDomain(it) }
        }
    }
}