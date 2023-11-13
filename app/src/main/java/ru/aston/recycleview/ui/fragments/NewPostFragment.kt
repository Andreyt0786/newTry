package ru.aston.recycleview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import ru.aston.recycleview.R
import ru.aston.recycleview.databinding.FragmentNewPostBinding
import ru.aston.recycleview.dto.TelePhoneBook

class NewPostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNewPostBinding.inflate(
            inflater,
            container,
            false
        )


        binding.fab.setOnClickListener {
            val id = 0
            val name = binding.nameUser.text.toString()
            val surname = binding.surnameUser.text.toString()
            val telephone = binding.telephoneUser.text.toString()

            if (binding.nameUser.text.toString().isNotEmpty() &&
                binding.surnameUser.text.toString().isNotEmpty() &&
                binding.telephoneUser.text.toString().isNotEmpty()
            ) {
                setFragmentResult(
                    "key", bundleOf(
                        "result key" to TelePhoneBook(
                            id,
                            name,
                            surname,
                            telephone
                        )
                    )
                )

                parentFragmentManager.popBackStack()
            } else {
                Toast.makeText(
                    requireContext(),
                    R.string.need_to_feel,
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
        return binding.root
    }
}
