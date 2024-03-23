package ru.kpfu.itis.android.asadullin.mywallet.domain.model

sealed class TransactionModel

data class Transaction(val transaction: TransactionDomain): TransactionModel()

data class TransactionDate(val date: String): TransactionModel()