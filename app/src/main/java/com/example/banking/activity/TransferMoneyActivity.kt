package com.example.banking.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banking.R
import com.example.banking.databinding.ActivityMoneyTransferBinding
import com.example.banking.databinding.ActivityTransferMoneyBinding

class TransferMoneyActivity : BaseActivity<ActivityTransferMoneyBinding>(ActivityTransferMoneyBinding::inflate) {
    private lateinit var name : String
    private lateinit var acNO : String
    private lateinit var BankName : String

    override fun initView() {
        val intent  = intent
        name = intent.getStringExtra("name").toString()
        acNO = intent.getStringExtra("account").toString()
        BankName = intent.getStringExtra("Bank").toString()

        binding.etName1.setText(name)
        binding.etAccountNumber1.setText(acNO)
        binding.etBankName1.setText(BankName)

    }


}