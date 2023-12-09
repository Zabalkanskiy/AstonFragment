package com.aston.astonfragment.second_task.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.aston.astonfragment.R
import com.aston.astonfragment.second_task.data.Person

class ListUserViewHolder(itemView: View) : ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.list_user_recycler_text_view_name)
    val surname: TextView = itemView.findViewById(R.id.list_user_recycler_text_view_surname)
    val phoneNumber: TextView = itemView.findViewById(R.id.list_user_recycler_text_view_phone_number)
    val imageView: ImageView = itemView.findViewById(R.id.list_user_recycler_image_view)

    fun bind(model: Person){
        name.text = model.name
        surname.text = model.surname
        phoneNumber.text = model.phoneNumber
        imageView.setImageResource(model.photo)
    }
}