package com.example.banking.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banking.Domain.MAtmTransDomain
import com.example.banking.R
import com.example.banking.adapter.MAtmTransAdapter
import com.example.banking.databinding.ActivityMatmTransactionBinding

class MAtmTransaction : AppCompatActivity() {
    private lateinit var binding: ActivityMatmTransactionBinding
    private lateinit var adapter: MAtmTransAdapter
    private lateinit var originalDataList: MutableList<MAtmTransDomain>
    private var isSortedDescending = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatmTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactionDataList = mutableListOf<MAtmTransDomain>()
        // Adding sample data
        transactionDataList.add(MAtmTransDomain("John Doe", "1234 5678 9012 3456", "1234567890", "BILL001", "TXN001", "ORDER001", 100.0,R.drawable.green_tick))
        transactionDataList.add(MAtmTransDomain("Jane Smith", "9876 5432 1098 7654", "0987654321", "BILL002", "TXN002", "ORDER002", 150.0,R.drawable.red_cross))
        transactionDataList.add(MAtmTransDomain("Alice Johnson", "5678 1234 3456 7890", "5678901234", "BILL003", "TXN003", "ORDER003", 200.0,R.drawable.green_tick))

        originalDataList = transactionDataList.toMutableList()

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.matmTransaction.layoutManager = layoutManager

        adapter = MAtmTransAdapter(transactionDataList)
        binding.matmTransaction.adapter = adapter

        val autoCompleteAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, originalDataList.map { it.name })
        binding.autoCompleteTextView.setAdapter(autoCompleteAdapter)

        binding.autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedName = autoCompleteAdapter.getItem(position)
            val filteredList = originalDataList.filter { it.name == selectedName }
            adapter.updateList(filteredList)
            showFilterDialog()
        }

        binding.filterButton.setOnClickListener {
            showFilterDialog()
        }
    }

    private fun showFilterDialog() {
        val filterText = binding.autoCompleteTextView.text.toString().trim()
        val filteredList = if (filterText.isNotEmpty()) {
            originalDataList.filter { it.name.contains(filterText, ignoreCase = true) }
        } else {
            originalDataList
        }
        val sortedList = if (isSortedDescending) {
            filteredList.sortedByDescending { it.name }
        } else {
            filteredList.sortedBy { it.name }
        }
        adapter.updateList(sortedList)
        isSortedDescending = !isSortedDescending
    }
}
