package coder.mtk.centralbankapi.api

import coder.mtk.centralbankapi.model.CBBank
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://forex.cbm.gov.mm/api/"

    private val apiInterface : ApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getExchangeRateByDate (date : String) : Call<CBBank>{
        return apiInterface.getExchangeRateByDate(date)
    }
}