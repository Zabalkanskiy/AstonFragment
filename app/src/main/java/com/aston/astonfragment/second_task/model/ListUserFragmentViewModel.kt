package com.aston.astonfragment.second_task.model

import androidx.lifecycle.ViewModel
import com.aston.astonfragment.second_task.data.Person
import com.aston.astonfragment.second_task.repository.ListUserFragmentRepository

class ListUserFragmentViewModel(listUserFragmentRepository: ListUserFragmentRepository) : ViewModel(){
    private val repository = listUserFragmentRepository

    fun getPersons(): List<Person>{
        return repository.listPerson
    }

    fun updateList(person: Person, position: Int) : List<Person>{
        val listPerson = repository.listPerson.toMutableList()
        listPerson.set(position, person)
        //repository.listPerson = listPerson
        return listPerson
    }
    fun saveList(list: List<Person>){
        repository.listPerson = list
    }
}