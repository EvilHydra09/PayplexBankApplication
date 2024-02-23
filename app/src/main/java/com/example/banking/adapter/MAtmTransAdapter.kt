package com.example.banking.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banking.Domain.MAtmTransDomain
import com.example.banking.databinding.MatmtransactionItemBinding

class MAtmTransAdapter(private var transactionDataList: List<MAtmTransDomain>) :
    RecyclerView.Adapter<MAtmTransAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MatmtransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    fun updateList(newList: List<MAtmTransDomain>) {
        transactionDataList = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transactionData = transactionDataList[position]
        holder.bind(transactionData)
    }

    override fun getItemCount(): Int {
        return transactionDataList.size
    }

    inner class ViewHolder(private val binding: MatmtransactionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(transactionData: MAtmTransDomain) {
            binding.apply {
                userName.text = transactionData.name
                matmCardNo.text = transactionData.cardNo
                matmMobNo.text = transactionData.mobileNo
                matmBillNo.text = transactionData.billNo
                matmTxnId.text = transactionData.txnId
                matmOrderId.text = transactionData.orderId
                matmAmount.text = transactionData.amount.toString()
                matmTransIcon.setImageResource(transactionData.icon)
            }
        }
    }
}