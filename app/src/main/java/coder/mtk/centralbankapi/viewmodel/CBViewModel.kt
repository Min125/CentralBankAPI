package coder.mtk.centralbankapi.viewmodel

import android.util.MutableDouble
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coder.mtk.centralbankapi.api.ApiClient
import coder.mtk.centralbankapi.model.CBBank
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CBViewModel  : ViewModel() {
    private var data : MutableLiveData<CBBank> = MutableLiveData()

    fun getdata() : LiveData<CBBank> = data

    fun loadData(date : String){
        val apiClient = ApiClient()
        val apiCall = apiClient.getExchangeRateByDate(date)

        apiCall.enqueue(object : Callback<CBBank>{
            override fun onResponse(call: Call<CBBank>, response: Response<CBBank>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<CBBank>, t: Throwable) {

            }

        })
    }
}