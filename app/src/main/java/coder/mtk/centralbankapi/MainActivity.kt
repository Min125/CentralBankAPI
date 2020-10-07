package coder.mtk.centralbankapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import coder.mtk.centralbankapi.api.ApiClient
import coder.mtk.centralbankapi.model.CBBank
import coder.mtk.centralbankapi.viewmodel.CBViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: CBViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CBViewModel::class.java)

        btnSearch.setOnClickListener{
            val day = day.text.toString()
            val month = month.text.toString()
            val year = year.text.toString()

            val date : String = day+"-"+month+"-"+year
            Log.d("date>>",date)


            viewModel.loadData(date)
            viewModel.getdata().observe(
                this, androidx.lifecycle.Observer {
                    usdData.text = it.rates.USD
                }
            )



        }

    }
}