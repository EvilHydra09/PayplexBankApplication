package com.example.banking.activity

import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.banking.Domain.BankListResponse
import com.example.banking.Domain.Data
import com.example.banking.Domain.DmtAddBenefieryRequest
import com.example.banking.Domain.DmtAddBenefieryResponse
import com.example.banking.databinding.ActivityAddBenefiaryBinding
import com.example.banking.retrofit.ApiService
import com.example.banking.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddBeneficiaryActivity : BaseActivity<ActivityAddBenefiaryBinding>(ActivityAddBenefiaryBinding::inflate) {
    private lateinit var bank_code : String
    private  lateinit var cMobile : String
    private lateinit var bankAdapter: ArrayAdapter<String>
    private val bankMap = HashMap<String, Int>()
    override fun initView() {
     val intent  = intent
      cMobile = intent.getStringExtra("cNumber").toString()

    }
    override fun onClick() {


        bankAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line)
        binding.etBankName.setAdapter(bankAdapter)


        binding.btAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val mobile = binding.etMobile.text.toString()
            val accountNumber = binding.etAccountNumber.text.toString()
            val ifsc = binding.etIFSC.text.toString()
            senddata(
                DmtAddBenefieryRequest(
                    mobile,
                    "34915002",
                    name,
                    ifsc,
                    accountNumber,
                    bank_code,
                    cMobile ,
                    "add_recipient"
                )
            )
        }


        binding.etBankName.setOnClickListener {
            fetchBankList()
           binding.tilBankName.isErrorEnabled = false // Clear any previous error
        }


        binding.etBankName.setOnItemClickListener { _, _, position, _ ->
            val selectedBankName = bankAdapter.getItem(position)
            selectedBankName?.let {
                bank_code = bankMap[selectedBankName].toString()
                binding.etBankName.setText(selectedBankName) // Set bank name to EditText
                Toast.makeText(this, "Selected Bank ID: $bank_code", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchBankList(){
        val apiService = RetrofitClient.getRetrofit().create(ApiService::class.java)
        val call = apiService.getbanklist()
        call.enqueue(object : Callback<BankListResponse> {
            override fun onResponse(
                call: Call<BankListResponse>,
                response: Response<BankListResponse>
            ) {
                if (response.isSuccessful) {
                    val banksResponse = response.body()
                    banksResponse?.data?.let { banks ->
                        bankAdapter.clear()
                        bankMap.clear()
                        for (bank in banks) {
                            bankAdapter.add(bank.bname)
                            bankMap[bank.bname] = bank.id
                        }
                        binding.etBankName.showDropDown()
                    }
                }
            }

            override fun onFailure(call: Call<BankListResponse>, t: Throwable) {
                // Handle network errors
            }
        })
    }

    private fun senddata(request: DmtAddBenefieryRequest) {
        val apiService = RetrofitClient.getRetrofit().create(ApiService::class.java)
        val call = apiService.addBeneficiary(request)
        call.enqueue(object : Callback<DmtAddBenefieryResponse> {
            override fun onResponse(
                call: Call<DmtAddBenefieryResponse>,
                response: Response<DmtAddBenefieryResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Toast.makeText(applicationContext, data.toString(), Toast.LENGTH_LONG).show()

                } else {
                    // Handle error response
                }
            }

            override fun onFailure(call: Call<DmtAddBenefieryResponse>, t: Throwable) {
                // Handle network errors
            }
        })
    }
}





