package com.example.midtermandroid

class FinanceManager {
    fun calculate(salary: Double, rent: Double, food: Double): FinanceModel {
        val totalExpenses = rent + food

        val surnameLength = "Maisadze".length
        val savingsPercent = surnameLength + 3 // 5 Marts Davibade

        val savings = salary * (savingsPercent / 100.0)
        val isPositive = salary >= totalExpenses

        return FinanceModel(salary, totalExpenses, savings, isPositive)
    }
}