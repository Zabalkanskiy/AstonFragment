package com.aston.astonfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aston.astonfragment.databinding.ActivityMainBinding
import com.aston.astonfragment.first_task.FirstTaskActivity
import com.aston.astonfragment.second_task.SecondTaskActivity


//const val SECONDTASK = "SECONDTASK"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        binding.mainActivityButtonFirstTask.setOnClickListener {
            val intent = Intent(this, FirstTaskActivity::class.java)
            startActivity(intent)
        }
        binding.mainActivityButtonSecondTask.setOnClickListener {
            val intent = Intent(this, SecondTaskActivity::class.java)
            startActivity(intent)
        }
    }
}