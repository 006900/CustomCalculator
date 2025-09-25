package com.example.calculatorpro.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculatorpro.core.CalculatorScreen
import com.example.calculatorpro.core.CalculatorViewModel
import com.example.calculatorpro.core.CurrencyConverterScreen

@Composable
fun NavigationWrapper(viewModel: CalculatorViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Calculator) {
        composable <Calculator>{ CalculatorScreen(viewModel = viewModel){navController.navigate(CurrencyConverter)} }
        composable <CurrencyConverter>{ CurrencyConverterScreen() }
    }
}