package com.example.composedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    val textFieldState = MutableLiveData<String>("")
    fun setTextField(value: String) {
        textFieldState.value = value
    }

    private val _currentData = MutableLiveData<MutableList<String>>(mutableListOf())
    val currentData: LiveData<MutableList<String>> get() = _currentData

    fun updateList(vararg values: String) {
        val updatedList = mutableListOf<String>()
        updatedList.addAll(_currentData.value ?: emptyList())
        updatedList.addAll(values)
        _currentData.value = updatedList
    }
}