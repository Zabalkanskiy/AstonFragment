package com.aston.astonfragment.first_task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.aston.astonfragment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentD.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentD : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonFragmentB: Button = view.findViewById(R.id.fragmentd_button_fragmentB)
        buttonFragmentB.setOnClickListener {
            parentFragmentManager.popBackStack(FRAGMENT_C, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentD.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = FragmentD()
    }
}