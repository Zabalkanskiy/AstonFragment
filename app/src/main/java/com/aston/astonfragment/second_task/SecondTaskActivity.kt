package com.aston.astonfragment.second_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aston.astonfragment.R
import com.aston.astonfragment.second_task.ui.ListUserFragment

const val LISTUSER = "LISTUSER"
const val EDITUSER = "EDITUSER"

class SecondTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)

        val tag = supportFragmentManager.findFragmentByTag(LISTUSER)
        if (tag == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.second_task_activity_container,
                    ListUserFragment.newInstance(),
                    LISTUSER
                )
                // empty activity else addToBackStack
                // .addToBackStack(LISTUSER)
                .commit()
        }
    }
}