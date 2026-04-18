package com.example.midtermandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midtermandroid.databinding.FragmentABinding

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentABinding.bind(view)

        binding.nmBtnCalculate.setOnClickListener {
            val salary = binding.nmEditSalary.text.toString().toDoubleOrNull() ?: 0.0
            val rent = binding.nmEditRent.text.toString().toDoubleOrNull() ?: 0.0
            val food = binding.nmEditFood.text.toString().toDoubleOrNull() ?: 0.0

            val bundle = Bundle().apply {
                putDouble("NM_SALARY", salary)
                putDouble("NM_RENT", rent)
                putDouble("NM_FOOD", food)
            }

            val fragmentB = FragmentB()
            fragmentB.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.nm_main_fragment_container, fragmentB)
                .commit()
        }
    }
}