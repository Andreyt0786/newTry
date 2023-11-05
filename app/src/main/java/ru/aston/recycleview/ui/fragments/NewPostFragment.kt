package ru.aston.recycleview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.aston.recycleview.R
import ru.aston.recycleview.adapter.OnInteractionListener
import ru.aston.recycleview.databinding.FragmentNewPostBinding
import ru.aston.recycleview.util.AndroidUtils
import ru.aston.recycleview.util.StringArg
import ru.aston.recycleview.viewModel.TelePhoneBookViewModel

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

        val viewModel: TelePhoneBookViewModel by viewModels(
            ownerProducer = ::requireParentFragment
        )


        binding.fab.setOnClickListener {
            if (binding.nameUser.text.toString().isNotEmpty() &&
                binding.surnameUser.text.toString().isNotEmpty() &&
                binding.telephoneUser.text.toString().isNotEmpty()
            ) {
                viewModel.change(
                    binding.nameUser.text.toString(),
                    binding.surnameUser.text.toString(),
                    binding.telephoneUser.text.toString(),
                )
                viewModel.save()
                AndroidUtils.hideKeyboard(requireView())
                findNavController().navigate(R.id.action_newPostFragment_to_feedFragment)
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
