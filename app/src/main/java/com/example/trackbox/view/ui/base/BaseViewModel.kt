package com.example.trackbox.view.ui.base

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.HttpException

abstract class BaseViewModel : ViewModel() {

    open val isLoading = MutableLiveData(View.INVISIBLE)
    open fun showLoading() = isLoading.postValue(View.VISIBLE)
    open fun hideLoading() = isLoading.postValue(View.INVISIBLE)


}