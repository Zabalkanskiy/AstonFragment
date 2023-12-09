package com.aston.astonfragment.second_task.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aston.astonfragment.second_task.repository.ListUserFragmentRepository

class ListUserFragmentViewModelFactory(private val listUserFragmentRepository: ListUserFragmentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListUserFragmentViewModel::class.java)) {
            return ListUserFragmentViewModel(listUserFragmentRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}