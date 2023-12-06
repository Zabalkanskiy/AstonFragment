package com.aston.astonfragment.first_task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.aston.astonfragment.R

const val FRAGMENT_A = "FRAGMENT_A"
const val FRAGMENT_B = "FRAGMENT_B"
const val FRAGMENT_C = "FRAGMENT_C"
const val FRAGMENT_D = "FRAGMENT_D"
class FragmentA : Fragment() {


    companion object {
        fun newInstance() = FragmentA()
    }

 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.first_task_fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonFragmentB = view.findViewById<Button>(R.id.first_task_button_fragmentB)
        val fragmentB = FragmentB.newInstance()
        buttonFragmentB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, fragmentB, FRAGMENT_B)
                .addToBackStack(FRAGMENT_B)
                .commit()
        }
    }

}