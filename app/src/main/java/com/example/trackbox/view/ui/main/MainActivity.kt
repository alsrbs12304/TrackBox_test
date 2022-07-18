package com.example.trackbox.view.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trackbox.R
import com.example.trackbox.data.RetrofitClient
import com.example.trackbox.databinding.ActivityMainBinding
import com.example.trackbox.model.DeliveryResponse
import com.example.trackbox.view.ui.add.AddDeliveryFragment
import com.example.trackbox.view.ui.add.AddDeliveryViewModel
import com.example.trackbox.view.ui.base.BaseActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var deliveryAdapter: MainDeliveryAdapter
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            MainViewModel.Factory(application)
        )[MainViewModel::class.java]
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {

        }
        binding.addDeliveryBtn.setOnClickListener {
            val bottomSheet : AddDeliveryFragment = AddDeliveryFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)
        deliveryAdapter = MainDeliveryAdapter()
        binding.recyclerViewMain.adapter = deliveryAdapter

        viewModel.getList().observe(this, Observer {
            deliveryAdapter.setList(it)
            deliveryAdapter.notifyDataSetChanged()
        })
    }

}