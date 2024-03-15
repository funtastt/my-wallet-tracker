package ru.kpfu.itis.android.asadullin.mywallet.di

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import ru.kpfu.itis.android.asadullin.data.handlers.ExceptionHandlerDelegate
import ru.kpfu.itis.android.asadullin.mywallet.data.local.ApplicationDatabase
import ru.kpfu.itis.android.asadullin.mywallet.data.local.repositories.CategoryRepositoryImpl
import ru.kpfu.itis.android.asadullin.mywallet.data.local.repositories.TransactionRepositoryImpl
import ru.kpfu.itis.android.asadullin.mywallet.domain.usecases.CalculateExpensesUseCase
import ru.kpfu.itis.android.asadullin.mywallet.domain.usecases.GetAllTransactionsUseCase
import ru.kpfu.itis.android.asadullin.mywallet.domain.usecases.SaveTransactionUseCase

object ServiceLocator {
    private const val DATABASE_NAME = "MyWalletTransactions.db"

    private var databaseInstance: ApplicationDatabase? = null

    private lateinit var transactionRepository: TransactionRepositoryImpl
    private lateinit var categoryRepository: CategoryRepositoryImpl


    lateinit var saveTransactionUseCase: SaveTransactionUseCase
        private set

    lateinit var getAllTransactionsUseCase: GetAllTransactionsUseCase
        private set


    lateinit var exceptionHandlerDelegate: ExceptionHandlerDelegate
        private set

    lateinit var calculateExpensesUseCase: CalculateExpensesUseCase
        private set

    fun createDatabase(context: Context) {
        databaseInstance =
            Room.databaseBuilder(context, ApplicationDatabase::class.java, DATABASE_NAME)
                .build()
    }

    fun initDataDependencies() {
        transactionRepository = TransactionRepositoryImpl(
            databaseInstance!!.transactionDao
        )

        categoryRepository = CategoryRepositoryImpl(
            databaseInstance!!.transactionDao
        )

        exceptionHandlerDelegate = ExceptionHandlerDelegate()
    }

    fun initDomainDependencies() {
        saveTransactionUseCase = SaveTransactionUseCase(
            transactionRepository = transactionRepository,
            dispatcher = Dispatchers.IO
        )

        getAllTransactionsUseCase = GetAllTransactionsUseCase(
            transactionRepository = transactionRepository,
            dispatcher = Dispatchers.IO
        )

        calculateExpensesUseCase = CalculateExpensesUseCase(
            categoryRepository = categoryRepository,
            dispatcher = Dispatchers.IO
        )
    }

    fun getDatabaseInstance(): ApplicationDatabase {
        return databaseInstance ?: throw RuntimeException("Database is not initialized yet")
    }
}