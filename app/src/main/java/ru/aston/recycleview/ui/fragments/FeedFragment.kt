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
import ru.aston.recycleview.adapter.TelePhoneBookAdapter
import ru.aston.recycleview.databinding.FragmentFeedBinding
import ru.aston.recycleview.dto.TelePhoneBook
import ru.aston.recycleview.viewModel.TelePhoneBookViewModel

class FeedFragment : Fragment() {
    private val viewModel: TelePhoneBookViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(
            inflater,
            container,
            false
        )

        val bundle =  Bundle()

        val adapter = TelePhoneBookAdapter(object : OnInteractionListener {
            override fun onEdit(telePhoneBook: TelePhoneBook) {
                viewModel.edit(telePhoneBook)
            }

            override fun onRemove(telePhoneBook: TelePhoneBook) {
                viewModel.removeById(telePhoneBook.id)
            }
        })
        binding.list.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner) { telePhoneBook ->
            adapter.submitList(telePhoneBook)
        }

        viewModel.edited.observe(viewLifecycleOwner) { telePhoneBook ->
            if (telePhoneBook.id == 0) {
                return@observe
            }
            val list = arrayListOf<String>(telePhoneBook.name,telePhoneBook.surName,telePhoneBook.number)
            bundle.putStringArrayList("parametrs",list)
            findNavController().navigate(R.id.action_feedFragment_to_changePostFragment,
               bundle)
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_feedFragment_to_newPostFragment)
        }

        return binding.root
    }
}