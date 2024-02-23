package com.example.banking.Domain

data class DmtAddBenefieryRequest(
    val mobile:String,
    val user_code: String,
    val name : String,
    val ifsc : String,
    val account:String,
    val bank_code:String,
    val cmobile : String,
    val service_request: String
)
