package com.aston.astonfragment.second_task.repository

import com.aston.astonfragment.R
import com.aston.astonfragment.second_task.data.Person

class ListUserFragmentRepository {
    var listPerson : List<Person>
    init {
        listPerson = MutableList(8){
            Person(
                id = it,
                photo = R.drawable.placeholder,
                name = "Name $it",
                surname = "Surname $it",
                phoneNumber = "892000000$it"
            )
        }
    }
}