package com.example.midtermandroid

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.midtermandroid.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val salary = arguments?.getDouble("NM_SALARY") ?: 0.0
        val rent = arguments?.getDouble("NM_RENT") ?: 0.0
        val food = arguments?.getDouble("NM_FOOD") ?: 0.0

        val manager = FinanceManager()
        val result = manager.calculate(salary, rent, food)

        binding.nmTxtExpensesResult.text = getString(R.string.nm_expenses_format, result.expenses)


        if (result.isPositive) {
            binding.nmTxtSavingsResult.text = getString(R.string.nm_savings_format, result.savings)
            binding.nmTxtExpensesResult.setTextColor(Color.GREEN)
            binding.nmTxtSavingsResult.setTextColor(Color.GREEN)
        } else {
            binding.nmTxtSavingsResult.text = getString(R.string.nm_loss_format, result.savings)
            binding.nmTxtExpensesResult.setTextColor(Color.RED)
            binding.nmTxtSavingsResult.setTextColor(Color.RED)
        }
    }
}