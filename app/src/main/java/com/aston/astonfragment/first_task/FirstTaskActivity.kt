package com.aston.astonfragment.first_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aston.astonfragment.R
import com.aston.astonfragment.first_task.ui.FragmentA

//const val FIRSTTASK = "FIRSTTASK"
class FirstTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)
        if (savedInstanceState == null) {
           // supportFragmentManager.findFragmentByTag()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentA.newInstance())
                .commitNow()
        }
    }
}