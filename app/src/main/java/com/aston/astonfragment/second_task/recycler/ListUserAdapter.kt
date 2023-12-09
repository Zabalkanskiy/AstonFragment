package com.aston.astonfragment.second_task.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.aston.astonfragment.R
import com.aston.astonfragment.second_task.data.Person

class ListUserAdapter(private val onClickAction: (person: Person, position : Int) -> Unit): ListAdapter<Person, ListUserViewHolder>(MainDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_user_recycler_view_layout, parent, false)
        val viewHolder = ListUserViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val item = getItem(viewHolder.adapterPosition)
            val position = viewHolder.adapterPosition

            onClickAction(item, position)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(item)
    }
}