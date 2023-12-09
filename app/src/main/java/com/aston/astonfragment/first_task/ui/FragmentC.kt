package com.aston.astonfragment.first_task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.aston.astonfragment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAMC1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentC.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentC : Fragment() {
    // TODO: Rename and change types of parameters
    private var stringFromBFragment: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stringFromBFragment = it.getString(ARG_PARAMC1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonD: Button = view.findViewById(R.id.fragmentc_button_fragmentD)
        val buttonA: Button = view.findViewById(R.id.fragmentc_button_fragmenta)
        val messageTextView: TextView = view.findViewById(R.id.fragmentc_text_view_message)
        messageTextView.text = stringFromBFragment

        buttonD.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentD.newInstance(), FRAGMENT_D)
                .addToBackStack(FRAGMENT_D)
                .commit()

        }

        buttonA.setOnClickListener {
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
         * @return A new instance of fragment FragmentC.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentC().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAMC1, param1)
                }
            }
    }
}