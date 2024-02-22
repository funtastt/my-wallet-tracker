package ru.kpfu.itis.android.asadullin.mywallet.di

//import android.content.Context
//import androidx.room.Room
////import ru.kpfu.itis.android.asadullin.mywallet.data.db.ApplicationDatabase
//
//object ServiceLocator {
//    private const val DATABASE_NAME = "MyWalletTransactions.db"
//
//    private var databaseInstance : ApplicationDatabase? = null
//    fun createDatabase(context: Context) {
//        databaseInstance = Room.databaseBuilder(context, ApplicationDatabase::class.java, DATABASE_NAME)
////            .fallbackToDestructiveMigration()
////            .addMigrations()
//            .build()
//    }
//    fun getDatabaseInstance() : ApplicationDatabase {
//        return databaseInstance ?: throw RuntimeException("Database is not initialized yet")
//    }
//}