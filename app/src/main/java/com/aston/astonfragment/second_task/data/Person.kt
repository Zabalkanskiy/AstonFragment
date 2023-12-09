package com.aston.astonfragment.second_task.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Person(val id: Int, @DrawableRes var photo: Int, val name: String, val surname: String, val phoneNumber: String) : Parcelable
