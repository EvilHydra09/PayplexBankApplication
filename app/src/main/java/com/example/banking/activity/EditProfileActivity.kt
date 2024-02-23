package com.example.banking.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banking.R
import com.example.banking.databinding.ActivityEditProfileBinding

class EditProfileActivity : BaseActivity<ActivityEditProfileBinding>(ActivityEditProfileBinding::inflate) {
    override fun onClick() {
        binding.apply {
            icProfileBack.setOnClickListener{
                val intent = Intent(applicationContext,ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}