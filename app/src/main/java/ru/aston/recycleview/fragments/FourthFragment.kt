package ru.aston.recycleview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.aston.recycleview.R
import ru.aston.recycleview.databinding.FragmentFourthBinding

@Suppress("DEPRECATION")
class FourthFragment: Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFourthBinding.inflate(
            inflater,
            container,
            false
        )

        val fragment = SecondFragment()
        binding.buttomB.setOnClickListener {


            fragmentManager?.beginTransaction()?.run {
                replace(R.id.nav_container, fragment)
                //((AppCompatActivity)getContext()).getSupportFragmentManager().popBackStack(String name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                fragmentManager?.popBackStack("Third fragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                commit()
            }

        }
        return binding.root
    }
}