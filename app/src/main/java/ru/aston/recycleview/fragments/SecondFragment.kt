package ru.aston.recycleview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.aston.recycleview.R
import ru.aston.recycleview.databinding.FragmentSecondBinding

@Suppress("DEPRECATION")
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSecondBinding.inflate(
            inflater,
            container,
            false
        )

        val text = "Hello fragment C!!!!!"

        val bundle = Bundle()

        binding.buttomA.setOnClickListener {
            val fragment = FirstFragment()

            fragmentManager?.beginTransaction()?.run {
                replace(R.id.nav_container, fragment)
                addToBackStack("second fragment")
                commit()
            }
        }

            binding.buttomC.setOnClickListener {
                val fragment = ThirdFragment()

                fragmentManager?.beginTransaction()?.run {
                    bundle.putString("data", text)
                    fragment.arguments = bundle
                    replace(R.id.nav_container, fragment)
                    addToBackStack("second fragment")
                    commit()
                }

            }
            return binding.root
        }
    }