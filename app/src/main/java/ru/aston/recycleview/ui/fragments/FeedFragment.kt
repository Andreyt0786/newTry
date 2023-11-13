package ru.aston.recycleview.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import ru.aston.recycleview.R
import ru.aston.recycleview.adapter.OnInteractionListener
import ru.aston.recycleview.adapter.TelePhoneBookAdapter
import ru.aston.recycleview.databinding.FragmentFeedBinding
import ru.aston.recycleview.dto.TelePhoneBook
import ru.aston.recycleview.viewModel.TelePhoneBookViewModel

class FeedFragment : Fragment() {
    private val viewModel: TelePhoneBookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Use the Kotlin extension in the fragment-ktx artifact.
        setFragmentResultListener("key") { _, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported.
            val data = bundle.getSerializable("result key")
            // Do something with the result.
            if (data is TelePhoneBook) {
                viewModel.change(
                    data.id,
                    data.name,
                    data.surName,
                    data.number
                )
                viewModel.save()
            }
        }
    }

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

        val newFragment = NewPostFragment()
        val changeFragment = ChangePostFragment()
        val bundle = Bundle()

        val list: MutableSet<Int> = mutableSetOf()

        val adapter = TelePhoneBookAdapter(object : OnInteractionListener {
            override fun onEdit(telePhoneBook: TelePhoneBook) {
                viewModel.edit(telePhoneBook)
            }

            override fun onRemove(telePhoneBook: TelePhoneBook) {
                viewModel.removeById(telePhoneBook.id)
            }


            override fun onCheck(telePhoneBook: TelePhoneBook) {
                if (!telePhoneBook.isChecked) {
                    list.add(telePhoneBook.id)
                    Log.d("CHECK", "Add id = $telePhoneBook.id")
                } else {
                    list.remove(telePhoneBook.id)
                    Log.d("CHECK", "Remove id = $telePhoneBook.id")
                }

                viewModel.check(telePhoneBook.id)
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
            val listBundle =
                arrayListOf<String>(
                    telePhoneBook.id.toString(),
                    telePhoneBook.name,
                    telePhoneBook.surName,
                    telePhoneBook.number
                )
            bundle.putStringArrayList("parametrs", listBundle)

            /*findNavController().navigate(R.id.action_feedFragment_to_changePostFragment,
               bundle)*/
            changeFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_container, changeFragment)
                .addToBackStack("Feed Fragment")
                .commit()
        }

        binding.fab.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_container, newFragment)
                .addToBackStack("Feed Fragment")
                .commit()
        }


        binding.delete.setOnClickListener {
            for (s in list) {
                viewModel.removeById(s)
                Log.d("CHECK", "Delete id = $s")
            }
            list.clear()
        }

        return binding.root
    }
}