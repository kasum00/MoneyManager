package com.huyen.moneymanager.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.huyen.moneymanager.data.local.TransactionEntity
import com.huyen.moneymanager.data.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    fun addTransaction(
        title: String,
        amount: Double,
        type: String
    ) {

        viewModelScope.launch {

            val transaction = TransactionEntity(
                title = title,
                amount = amount,
                type = type,
                date = System.currentTimeMillis()
            )

            repository.insert(transaction)

        }

    }

}