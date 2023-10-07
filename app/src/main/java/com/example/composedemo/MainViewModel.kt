package com.example.composedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val counterLiveData = MutableLiveData<Int>(0)

    fun incrementCounter() {
        counterLiveData.postValue(counterLiveData.value?.plus(1))
    }

    fun decrementCounter() {
        counterLiveData.postValue(counterLiveData.value?.minus(1))
    }

    fun observeCounter(): LiveData<Int> {
        return counterLiveData
    }

}