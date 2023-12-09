package com.aston.astonfragment.second_task.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aston.astonfragment.second_task.repository.EditTextFragmentRepository
import com.aston.astonfragment.second_task.repository.ListUserFragmentRepository

class EditTextFragmentViewModelFactory(private val editTextFragmentRepository: EditTextFragmentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditTextFragmentViewModel::class.java)) {
            return EditTextFragmentViewModel(editTextFragmentRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
