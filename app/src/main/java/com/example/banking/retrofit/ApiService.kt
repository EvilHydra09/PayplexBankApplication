package com.example.banking.retrofit

import com.example.banking.Domain.BankListResponse
import com.example.banking.Domain.DmtAddBenefieryRequest
import com.example.banking.Domain.DmtAddBenefieryResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("dmtapi")
    fun addBeneficiary(@Body request: DmtAddBenefieryRequest): Call<DmtAddBenefieryResponse>

    @POST("banks")
    fun getbanklist():Call<BankListResponse>
}