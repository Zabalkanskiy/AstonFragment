package com.aston.astonfragment.second_task.recycler

import androidx.recyclerview.widget.DiffUtil
import com.aston.astonfragment.second_task.data.Person


object MainDiffUtil : DiffUtil.ItemCallback<Person>(){
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.equals(newItem)
    }
}