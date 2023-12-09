package com.aston.astonfragment.first_task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.aston.astonfragment.R


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentB : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonFragmentC: Button = view.findViewById(R.id.fragmentb_button_fragmentC)
        val buttonFragmentA: Button = view.findViewById(R.id.fragmentb_button_to_fragment_a)

        buttonFragmentC.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentC.newInstance("Hello Fragment C"), FRAGMENT_C)
                .addToBackStack(FRAGMENT_C)
                .commit()
        }

        buttonFragmentA.setOnClickListener {
            parentFragmentManager.popBackStack(FRAGMENT_B, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentB.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = FragmentB()


    }
}