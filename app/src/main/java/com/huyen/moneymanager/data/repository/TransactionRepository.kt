package com.huyen.moneymanager.data.repository

import com.huyen.moneymanager.data.local.TransactionDao
import com.huyen.moneymanager.data.local.TransactionEntity
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val dao: TransactionDao
) {

    fun getTransactions() = dao.getAllTransactions()

    suspend fun insert(transaction: TransactionEntity) {
        dao.insert(transaction)
    }

    suspend fun delete(transaction: TransactionEntity) {
        dao.delete(transaction)
    }
}