package com.aston.astonfragment.second_task.model

import androidx.lifecycle.ViewModel
import com.aston.astonfragment.second_task.repository.EditTextFragmentRepository

class EditTextFragmentViewModel(editTextFragmentRepository: EditTextFragmentRepository): ViewModel() {
    private val repository = editTextFragmentRepository

    fun savePhotoId(photoId: Int){
        repository.photoId = photoId
    }

    fun getPhotoId(): Int{
        return repository.photoId as Int
    }

    fun savePosition(position: Int){
        repository.position = position
    }

    fun getPosition(): Int{
        return repository.position as Int
    }

    fun savePhotoFromApi(photoId: Int){
        repository.imageFromDialog = photoId
    }

    fun getPhotoFromApi():Int?{
        return repository.imageFromDialog
    }
}