package com.example.calculatorpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorpro.core.CalculatorViewModel
import com.example.calculatorpro.core.CurrencyConverterScreen
import com.example.calculatorpro.core.navigation.NavigationWrapper
import com.example.calculatorpro.ui.theme.CalculatorProTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorProTheme {
                val viewModel = viewModels<CalculatorViewModel> ()
                NavigationWrapper(viewModel = viewModel.value)
            }
        }
    }
}
