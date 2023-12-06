package com.aston.astonfragment.first_task.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aston.astonfragment.R
import com.aston.astonfragment.first_task.model.FirstTaskFragmentViewModel

class FirstTaskFragment : Fragment() {

    companion object {
        fun newInstance() = FirstTaskFragment()
    }

    private lateinit var viewModel: FirstTaskFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FirstTaskFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.first_task_fragment_main, container, false)
        parentFragmentManager.beginTransaction().commit()
    }

}