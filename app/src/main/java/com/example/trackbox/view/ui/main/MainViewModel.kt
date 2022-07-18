package com.example.trackbox.view.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trackbox.data.repository.DeliveryRepository
import com.example.trackbox.model.entity.Delivery
import com.example.trackbox.view.ui.add.AddDeliveryViewModel
import com.example.trackbox.view.ui.base.BaseViewModel

class MainViewModel(private val repository: DeliveryRepository) : BaseViewModel(){

    fun getList() : LiveData<List<Delivery>>{
        return repository.getList()
    }

    class Factory(private val application: Application) :
        ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(DeliveryRepository.getInstance(application)!!) as T
        }
    }
}