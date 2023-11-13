package ru.aston.recycleview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import ru.aston.recycleview.databinding.FragmentNewPostBinding
import ru.aston.recycleview.dto.TelePhoneBook

class ChangePostFragment : Fragment() {

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

        //val viewModel: TelePhoneBookViewModel by viewModels()

        val id = arguments?.getStringArrayList("parametrs")!![0].toInt()


        arguments?.getStringArrayList("parametrs")!![1]?.let(binding.nameUser::setText)
        arguments?.getStringArrayList("parametrs")!![3]?.let(binding.telephoneUser::setText)
        arguments?.getStringArrayList("parametrs")!![2]?.let(binding.surnameUser::setText)


        binding.fab.setOnClickListener {
            val name = binding.nameUser.text.toString()
            val surname = binding.surnameUser.text.toString()
            val telephone = binding.telephoneUser.text.toString()
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
            /*val list =
                arrayListOf<String>(
                    id,
                    binding.nameUser.text.toString(),
                    binding.surnameUser.text.toString(),
                    binding.telephoneUser.text.toString()
                )
            bundle.putStringArrayList("parametrsBack", list)
            setFragmentResult("key", bundle)*/
            /*viewModel.change(
                binding.nameUser.text.toString(),
                binding.surnameUser.text.toString(),
                binding.telephoneUser.text.toString(),
            )
            viewModel.save()
            AndroidUtils.hideKeyboard(requireView())
            //findNavController().navigate(R.id.action_changePostFragment_to_feedFragment)
*/
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }
}
