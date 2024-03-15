package ru.kpfu.itis.android.asadullin.mywallet.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kpfu.itis.android.asadullin.mywallet.data.local.dao.TransactionDao
import ru.kpfu.itis.android.asadullin.mywallet.data.local.entity.TransactionEntity

@Database(
    entities = [TransactionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract val transactionDao : TransactionDao
}