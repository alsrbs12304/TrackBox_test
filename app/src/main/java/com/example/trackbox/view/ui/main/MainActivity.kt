package com.example.trackbox.view.ui.main

import android.os.Bundle
import com.example.trackbox.R
import com.example.trackbox.databinding.ActivityMainBinding
import com.example.trackbox.view.ui.add.AddDeliveryFragment
import com.example.trackbox.view.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {

        }
        binding.addDeliveryBtn.setOnClickListener {
            val bottomSheet : AddDeliveryFragment = AddDeliveryFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

        // Retrofit Test
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
//        val retrofit = Retrofit.Builder().baseUrl("https://apis.tracker.delivery/")
//            .addConverterFactory(GsonConverterFactory.create()).build()
//        val service = retrofit.create(DeliveryService::class.java)
//        service.getData("kr.cjlogistics","649685540992").enqueue(object : Callback<DeliveryResponse>{
//            override fun onResponse(call: Call<DeliveryResponse>, response: Response<DeliveryResponse>) {
//                if(response.isSuccessful){
//                    val result : DeliveryResponse? = response.body()
//                    Log.d("MainActivity", "onResponse 성공: " + result?.toString());
//                    Log.d("MainActivity", "onResponse 성공: " + result?.from?.name);
//                }else{
//                    Log.d("MainActivity", "onResponse 실패")
//                }
//            }
//            override fun onFailure(call: Call<DeliveryResponse>, t: Throwable) {
//                Log.d("MainActivity", "onFailure 에러: " + t.message.toString());
//            }
//        })
        //////////////////////////////////////////////////////////////////////////////////////////////////////////


}