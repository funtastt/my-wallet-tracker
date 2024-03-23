package ru.kpfu.itis.android.asadullin.mywallet.data.local.mappers

import ru.kpfu.itis.android.asadullin.mywallet.data.local.entity.TransactionEntity
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.TransactionDomain
import ru.kpfu.itis.android.asadullin.mywallet.domain.model.enums.TransactionCategoryType
import java.util.Date

object TransactionMapper {

    fun mapToEntity(transaction: TransactionDomain): TransactionEntity {
        return TransactionEntity(
            transactionCategory = transaction.transactionCategory.name,
            transactionDescription = transaction.transactionDescription,
            isIncome = transaction.isIncome,
            transactionAmount = transaction.transactionAmount,
            transactionDate = transaction.transactionDate.time
        )
    }

    fun mapToDomain(transactionEntity: TransactionEntity): TransactionDomain {
        return TransactionDomain(
            transactionId = transactionEntity.transactionId,
            transactionCategory = TransactionCategoryType.valueOf(transactionEntity.transactionCategory),
            transactionDescription = transactionEntity.transactionDescription,
            isIncome = transactionEntity.isIncome,
            transactionAmount = transactionEntity.transactionAmount,
            transactionDate = Date(transactionEntity.transactionDate)
        )
    }
}