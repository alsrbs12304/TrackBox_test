package com.example.trackbox.view.ui.add

import com.example.trackbox.data.repository.DeliveryRepository
import com.example.trackbox.model.entity.Delivery
import com.example.trackbox.view.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class AddDeliveryViewModel(private val repository: DeliveryRepository) : BaseViewModel() {

    fun insert(delivery: Delivery){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(delivery)
        }
    }

}