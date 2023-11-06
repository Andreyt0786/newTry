package ru.aston.recycleview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.aston.recycleview.R
import ru.aston.recycleview.databinding.FragmentFirstBinding

@Suppress("DEPRECATION")
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFirstBinding.inflate(
            inflater,
            container,
            false
        )
        binding.buttom.setOnClickListener {
            val fragment = SecondFragment()
            fragmentManager?.beginTransaction()?.run {
                replace(R.id.nav_container, fragment)
                addToBackStack("first fragment")
                commit()
            }
        }
        return binding.root
    }
}