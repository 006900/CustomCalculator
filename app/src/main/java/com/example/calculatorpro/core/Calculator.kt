package com.example.calculatorpro.core

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorpro.ui.theme.Primary

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier,viewModel: CalculatorViewModel) {
    Scaffold(
        topBar = {},
        content = { innerPadding ->
            Content(modifier = modifier
                .background(Primary)
                .padding(innerPadding),viewModel = viewModel)
        }
    )
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
private fun Content(modifier: Modifier = Modifier, viewModel: CalculatorViewModel) {
    val displayText = viewModel.state.text
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(horizontalAlignment = Alignment.End) {
                Text(displayText, fontSize = 25.sp)
                Text("408", fontSize = 15.sp, color = Color.LightGray)
            }
        }
        ExampleButtons(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxSize()
                .padding(10.dp),
            viewModel = viewModel
        )
    }
}

@Composable
private fun ExampleButtons(modifier: Modifier = Modifier,viewModel: CalculatorViewModel) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "c"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "/"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "%"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "b"){viewModel.changeText(it)}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "7"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "8"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "9"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "*"){viewModel.changeText(it)}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "4"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "5"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "6"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "-"){viewModel.changeText(it)}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "1"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "2"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "3"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "+"){viewModel.changeText(it)}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(2f), value = "0"){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = ","){viewModel.changeText(it)}
            Buttons(modifier = Modifier.weight(1f), value = "="){viewModel.changeText(it)}
        }
    }
}

@Composable
private fun Buttons(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = CalculatorViewModel(),
    value: String,onClick:(String)-> Unit
) {
    val color = viewModel.changeColor(value)
    Card(
        modifier= Modifier
            .padding(3.dp)
            .then(modifier), shape = RoundedCornerShape(0),
        colors = CardDefaults.cardColors(color.backGround),
        onClick = { onClick(value) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = value, color = color.textColor)
        }
    }
}