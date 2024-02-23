package com.example.banking.Domain

data class MAtmTransDomain(
val name: String,
val cardNo: String,
val mobileNo: String,
val billNo: String,
val txnId: String,
val orderId: String,
val amount: Double,
val icon:Int
)

