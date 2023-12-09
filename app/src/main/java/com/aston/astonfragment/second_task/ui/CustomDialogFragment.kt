package com.aston.astonfragment.second_task.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.aston.astonfragment.R

class CustomDialogFragment : DialogFragment() {

    var resourcePhoto: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            resourcePhoto = it.getInt(RESOURCE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Используйте свой собственный макет (layout)
        return inflater.inflate(R.layout.person_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id: Int

        val cancelButton: Button = view.findViewById(R.id.person_dialog_button_cancel)
        val changeButton: Button = view.findViewById(R.id.person_dialog_button_change)
        val firstImageButton: ImageButton = view.findViewById(R.id.first_placeholder)
        val secondImageButton: ImageButton = view.findViewById(R.id.second_placeholder)
        val thirdImageButton: ImageButton = view.findViewById(R.id.third_placeholder)
        val fourImageButton: ImageButton = view.findViewById(R.id.four_placeholder)
        val imageView: ImageView = view.findViewById(R.id.image_placeholder)

        imageView.setImageResource(resourcePhoto as Int)

        firstImageButton.setOnClickListener {
            imageView.setImageResource(R.drawable.placeholder)
            resourcePhoto = R.drawable.placeholder
        }

        secondImageButton.setOnClickListener {
            imageView.setImageResource(R.drawable.placeholder_2)
            resourcePhoto = R.drawable.placeholder_2
        }

        thirdImageButton.setOnClickListener {
            imageView.setImageResource(R.drawable.placeholder_3)
            resourcePhoto = R.drawable.placeholder_3
        }

        fourImageButton.setOnClickListener {
            imageView.setImageResource(R.drawable.placeholder_4)
            resourcePhoto = R.drawable.placeholder_4
        }

        cancelButton.setOnClickListener {
            dismiss()

        }

        changeButton.setOnClickListener {
            //add Image
            //  newPhoto = id
            //  photoImage.setImageResource( id)
            setFragmentResult(
                "requestKey",
                bundleOf("resultKey" to resourcePhoto)
            )

            dismiss()


        }

        // Инициализация элементов управления и обработка событий
        // Например:
        /*
        val closeButton: Button = view.findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            dismiss() // Закрыть диалог при нажатии на кнопку
        }
        */
    }

    companion object {
        fun newInstance(resource: Int): CustomDialogFragment {
            return CustomDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt(RESOURCE, resource)
                }
            }
        }
    }
}