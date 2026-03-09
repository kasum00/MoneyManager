package com.huyen.moneymanager.di

import android.content.Context
import androidx.room.Room
import com.huyen.moneymanager.data.local.AppDatabase
import com.huyen.moneymanager.data.local.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {

        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "money_db"
        ).build()
    }

    @Provides
    fun provideDao(db: AppDatabase): TransactionDao {
        return db.transactionDao()
    }
}