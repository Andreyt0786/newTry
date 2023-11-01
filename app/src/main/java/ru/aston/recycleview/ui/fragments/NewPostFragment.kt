package ru.aston.recycleview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        arguments?.getStringArrayList("parametrs")!![0]?.let(binding.nameUser::setText)
        arguments?.getStringArrayList("parametrs")!![2]?.let(binding.telephoneUser::setText)
        arguments?.getStringArrayList("parametrs")!![1]?.let(binding.surnameUser::setText)

        binding.fab.setOnClickListener {
            viewModel.change(
                binding.nameUser.text.toString(),
                binding.surnameUser.text.toString(),
                binding.telephoneUser.text.toString(),
            )
            viewModel.save()
            AndroidUtils.hideKeyboard(requireView())
            findNavController().navigate(R.id.action_newPostFragment_to_feedFragment)
        }
        return binding.root
    }
}
