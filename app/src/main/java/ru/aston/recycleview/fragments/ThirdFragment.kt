package ru.aston.recycleview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.aston.recycleview.R
import ru.aston.recycleview.databinding.FragmentThirdBinding

@Suppress("DEPRECATION")
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentThirdBinding.inflate(
            inflater,
            container,
            false
        )

        binding.textReceive.text = arguments?.getString("data").toString()

        binding.buttomA.setOnClickListener {
            val fragment = FirstFragment()
            fragmentManager?.beginTransaction()?.run {
                replace(R.id.nav_container, fragment)
                fragmentManager?.popBackStack(
                    "second fragment",
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
                commit()
            }
        }

        binding.buttomD.setOnClickListener {
            val fragment = FourthFragment()

            fragmentManager?.beginTransaction()?.run {
                replace(R.id.nav_container, fragment)
                addToBackStack("Third fragment")
                commit()
            }

        }
        return binding.root
    }
}