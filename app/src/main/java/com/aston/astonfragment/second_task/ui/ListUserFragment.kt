package com.aston.astonfragment.second_task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.BundleCompat
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aston.astonfragment.R
import com.aston.astonfragment.second_task.EDITUSER
import com.aston.astonfragment.second_task.data.Person
import com.aston.astonfragment.second_task.model.ListUserFragmentViewModel
import com.aston.astonfragment.second_task.model.ListUserFragmentViewModelFactory
import com.aston.astonfragment.second_task.recycler.ListUserAdapter
import com.aston.astonfragment.second_task.repository.ListUserFragmentRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAMUSER1 = "param1"
private const val ARG_PARAMUSER2 = "param2"
 const val CHANGEPERSON = "CHANGEPERSON"

/**
 * A simple [Fragment] subclass.
 * Use the [ListUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListUserFragment : Fragment() {

    lateinit var listUserAdapter: ListUserAdapter
    lateinit var listUserFragmentViewModel: ListUserFragmentViewModel
    lateinit var person : Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        listUserAdapter = ListUserAdapter {person, position ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.second_task_activity_container,  EditUserFragment.newInstance(person, position))
                .addToBackStack(EDITUSER)
                .commit()

        }

        val viewModelFactory = ListUserFragmentViewModelFactory(ListUserFragmentRepository())

        listUserFragmentViewModel = ViewModelProvider(this, viewModelFactory).get(ListUserFragmentViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(CHANGEPERSON) { requestKey, bundle ->
            // Обработка результата от другого фрагмента

            person = BundleCompat.getParcelable(bundle, PERSON, Person::class.java) as Person
            val position = bundle.getInt(POSITION)


            val newList =  listUserFragmentViewModel.updateList(person, position)
            //может не пройти листы будут одинаковые
            listUserAdapter.submitList(newList)
            listUserFragmentViewModel.saveList(newList)

        }
       val listUserRecyclerView: RecyclerView =  view.findViewById(R.id.list_user_recycler_view)
        listUserRecyclerView.layoutManager = LinearLayoutManager(context)
        listUserRecyclerView.adapter = listUserAdapter

        val repPersons = listUserFragmentViewModel.getPersons()
        listUserAdapter.submitList(repPersons)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListUserFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = ListUserFragment()
    }
}