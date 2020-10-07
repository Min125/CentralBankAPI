package coder.mtk.centralbankapi.api

import coder.mtk.centralbankapi.model.CBBank
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("history/{date}")
    fun getExchangeRateByDate (
        @Path("date") date : String
    ) : Call<CBBank>
}