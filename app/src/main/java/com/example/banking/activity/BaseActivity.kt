package com.example.banking.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<_binding : ViewBinding>(val bindingFactory:(LayoutInflater)->_binding):AppCompatActivity() {

    lateinit var binding: _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)

        initVM()   // vm initilise
        initView()  // calling api
        setObserver()   //setobserver
        onClick()   //when perform onclick action
    }

    open fun onClick() {}

    open fun setObserver() {}

    open fun initView() {}

    open fun initVM() {}

}