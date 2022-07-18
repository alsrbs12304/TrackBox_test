package com.example.trackbox.view.ui.add

import android.app.Application
import com.example.trackbox.data.repository.DeliveryRepository
import com.example.trackbox.model.entity.Delivery
import com.example.trackbox.view.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.*
import com.example.trackbox.model.DeliveryResponse
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.launch

class AddDeliveryViewModel(private val repository: DeliveryRepository) : BaseViewModel() {

    val carrierName = MutableLiveData<String>()

    fun onClickInsertButton() {

    }

    fun insert(delivery: Delivery) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(delivery)
        }
    }

    class Factory(private val application: Application) :
        ViewModelProvider.Factory { // factory pattern
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AddDeliveryViewModel(DeliveryRepository.getInstance(application)!!) as T
        }
    }

}