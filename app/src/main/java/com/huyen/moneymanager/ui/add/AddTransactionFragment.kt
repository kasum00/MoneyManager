package com.huyen.moneymanager.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.huyen.moneymanager.R
import com.huyen.moneymanager.databinding.FragmentAddTransactionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTransactionFragment : Fragment(R.layout.fragment_add_transaction) {

    private val viewModel: AddTransactionViewModel by viewModels()

    private lateinit var binding: FragmentAddTransactionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddTransactionBinding.bind(view)

        binding.btnSave.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val amount = binding.edtAmount.text.toString().toDouble()
            val type = "expense"

            viewModel.addTransaction(title, amount, type)
            findNavController().popBackStack()
        }
    }
}