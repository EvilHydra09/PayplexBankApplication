package com.example.banking.Domain

data class BankListResponse(
    val `data`: List<Data>,
    val status: String
)