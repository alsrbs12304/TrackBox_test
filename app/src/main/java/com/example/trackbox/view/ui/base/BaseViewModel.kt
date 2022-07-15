package com.example.trackbox.view.ui.base

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackbox.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import kotlin.coroutines.coroutineContext

abstract class BaseViewModel : ViewModel() {

    open val isLoading = MutableLiveData(View.INVISIBLE)
    open fun showLoading() = isLoading.postValue(View.VISIBLE)
    open fun hideLoading() = isLoading.postValue(View.INVISIBLE)

    suspend fun <T> handle(call: suspend () -> T): T? {
        return withContext(CoroutineScope(coroutineContext).coroutineContext) {
            call.runCatching { this.invoke() }
                .getOrElse {
                    null
                }
        }
    }
}