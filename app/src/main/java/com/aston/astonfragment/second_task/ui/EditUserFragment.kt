package com.aston.astonfragment.second_task.ui

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.os.BundleCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.aston.astonfragment.R
import com.aston.astonfragment.first_task.ui.FRAGMENT_C
import com.aston.astonfragment.second_task.EDITUSER
import com.aston.astonfragment.second_task.data.Person
import com.aston.astonfragment.second_task.model.EditTextFragmentViewModel
import com.aston.astonfragment.second_task.model.EditTextFragmentViewModelFactory
import com.aston.astonfragment.second_task.model.ListUserFragmentViewModel
import com.aston.astonfragment.second_task.model.ListUserFragmentViewModelFactory
import com.aston.astonfragment.second_task.repository.EditTextFragmentRepository
import com.aston.astonfragment.second_task.repository.ListUserFragmentRepository
import com.google.android.material.dialog.MaterialAlertDialogBuilder


const val PERSON = "PERSON"
const val POSITION = "POSITION"
const val NAME = "NAME"
const val SURNAME = "SURNAME"
const val PHONENUMBER = "PHONENUMBER"
const val RESOURCEID = "RESOURCEID"
const val ID = "ID"

/**
 * A simple [Fragment] subclass.
 * Use the [EditUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditUserFragment : Fragment() {


    lateinit var person: Person
    lateinit var photoImage: ImageView
    lateinit var editTextViewModel: EditTextFragmentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModelFactory = EditTextFragmentViewModelFactory(EditTextFragmentRepository())
        editTextViewModel =
            ViewModelProvider(this, viewModelFactory).get(EditTextFragmentViewModel::class.java)



        /*  arguments?.let {


            person = Person(
                  id = it.getInt(ID),
                 photo = it.getInt(RESOURCEID),
                 name = it.getString(NAME, ""),
                 surname = it.getString(
                     SURNAME, ""
                ),
                phoneNumber = it.getString(PHONENUMBER, "")
            )
            editTextViewModel.savePhotoId(it.getInt(RESOURCEID))
             editTextViewModel.savePosition(it.getInt(POSITION))
        position = it.getInt(POSITION)
          }

         */

        arguments?.let {
            person = BundleCompat.getParcelable(it, PERSON, Person::class.java) as Person
            editTextViewModel.savePhotoId(person.photo)
            editTextViewModel.savePosition(it.getInt(POSITION))

        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            // Обработка результата от другого фрагмента
            // newPhoto = bundle.getInt("resultKey")
            editTextViewModel.savePhotoFromApi(bundle.getInt("resultKey"))

            // Делайте что-то с результатом
            photoImage.setImageResource(
                editTextViewModel.getPhotoFromApi() ?: editTextViewModel.getPhotoId()
            )

        }


        val nameEditText: EditText = view.findViewById(R.id.edit_user_edit_text_name)
        val surnameEditText: EditText = view.findViewById(R.id.edit_user_edit_text_surname)
        val phoneNumberEditText: EditText = view.findViewById(R.id.edit_user_edit_text_phone_number)
        photoImage = view.findViewById(R.id.edit_text_image_photo)
        val changePhotoButton: Button = view.findViewById(R.id.edit_text_button_change_photo)
        val closeButton: Button = view.findViewById(R.id.edit_text_button_close_button)
        val changeButton: Button = view.findViewById(R.id.edit_text_button_change_button)

        nameEditText.setText(person.name)
        surnameEditText.setText(person.surname)
        phoneNumberEditText.setText(person.phoneNumber)
        photoImage.setImageResource(
            editTextViewModel.getPhotoFromApi() ?: editTextViewModel.getPhotoId()
        )

        changePhotoButton.setOnClickListener {

            // createAlertDialog()
            val customDialogFragment = CustomDialogFragment.newInstance(resource = person.photo)
            customDialogFragment.show(
                requireActivity().supportFragmentManager,
                "CustomDialogFragment"
            )

        }

        closeButton.setOnClickListener {
            parentFragmentManager.popBackStack(EDITUSER, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        changeButton.setOnClickListener {
            val imageId = editTextViewModel.getPhotoFromApi() ?: editTextViewModel.getPhotoId()

            val newPerson = Person(id = person.id, photo = imageId, name = nameEditText.text.toString(), surname = surnameEditText.text.toString(), phoneNumber = phoneNumberEditText.text.toString() )
            val bundle = Bundle().apply {
                putParcelable(PERSON, newPerson)
                putInt(POSITION, editTextViewModel.getPosition())
            }
            setFragmentResult(
                CHANGEPERSON,

                bundle
            )
            parentFragmentManager.popBackStack(EDITUSER, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditUserFragment.
         */
        // TODO: Rename and change types and number of parameters
      /*  @JvmStatic
        fun newInstance(
            id: Int,
            name: String,
            surname: String,
            phoneNumber: String,
            resources: Int,
            position: Int
        ) =

            EditUserFragment().apply {
                arguments = Bundle().apply {

                    putInt(POSITION, position)
                    putInt(ID, id)
                    putString(NAME, name)
                    putString(SURNAME, surname)
                    putString(PHONENUMBER, phoneNumber)
                    putInt(RESOURCEID, resources)


                }
            }

       */

        @JvmStatic
        fun newInstance(person: Person, position: Int) =
            EditUserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PERSON, person)
                    putInt(POSITION, position)
                }
            }


    }

}


const val RESOURCE = "RESOURCE"