package com.example.calculatorpro.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.calculatorpro.ui.theme.Accent
import com.example.calculatorpro.ui.theme.Secondary
import com.example.calculatorpro.ui.theme.Tertiary

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(StateValue())
        private set

    fun changeText(value: String){
        state = state.copy(text = state.text + value )
    }
     fun changeColor(value: String): StateColor{
         val numericType = StateColor(textColor = Color.White, backGround = Secondary)
         val symbolType = StateColor(textColor = Accent, backGround = Tertiary)
         val result = StateColor(textColor = Color.White, backGround = Accent)
       return when(value){
           ",","0","1","2","3","4","5","6","7","8","9" -> {numericType}
            else -> { if (value == "=") result else symbolType }
        }
    }
}