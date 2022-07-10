package com.example.trackbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl("https://apis.tracker.delivery/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(DeliveryService::class.java)
        service.getData("kr.cjlogistics","649685540992").enqueue(object : Callback<DeliveryResponse>{
            override fun onResponse(call: Call<DeliveryResponse>, response: Response<DeliveryResponse>) {
                if(response.isSuccessful){
                    val result : DeliveryResponse? = response.body()
                    Log.d("MainActivity", "onResponse 성공: " + result?.toString());
                    Log.d("MainActivity", "onResponse 성공: " + result?.from?.name);
                }else{
                    Log.d("MainActivity", "onResponse 실패")
                }
            }
            override fun onFailure(call: Call<DeliveryResponse>, t: Throwable) {
                Log.d("MainActivity", "onFailure 에러: " + t.message.toString());
            }

        })
    }
}