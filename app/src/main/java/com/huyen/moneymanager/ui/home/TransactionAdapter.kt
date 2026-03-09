package com.huyen.moneymanager.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.huyen.moneymanager.data.local.TransactionEntity
import com.huyen.moneymanager.databinding.ItemTransactionBinding

class TransactionAdapter(
    private val onDelete: (TransactionEntity) -> Unit
) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    private var list: List<TransactionEntity> = emptyList()

    fun submitList(data: List<TransactionEntity>) {
        list = data
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.title.text = item.title
        holder.binding.amount.text = item.amount.toString()

        holder.binding.delete.setOnClickListener {
            onDelete(item)
        }
    }
}