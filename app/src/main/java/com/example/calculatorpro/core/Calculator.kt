package com.example.calculatorpro.core

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorpro.ui.theme.Primary

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {},
        content = { innerPadding ->
            Content(modifier = modifier.background(Primary).padding(innerPadding))
        }
    )
}

@Composable
private fun Content(modifier: Modifier = Modifier,) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ){
                Text("50+358", fontSize = 25.sp)
                Text("408",fontSize = 15.sp, color = Color.LightGray)
            }
        }
        ExampleButtons(
            modifier = Modifier
            .weight(0.6f)
            .fillMaxSize().padding(10.dp))
    }
}

@Composable
fun ExampleButtons(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "c"){}
            Buttons(modifier = Modifier.weight(1f), value = "/"){}
            Buttons(modifier = Modifier.weight(1f), value = "%"){}
            Buttons(modifier = Modifier.weight(1f), value = "b"){}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "7"){}
            Buttons(modifier = Modifier.weight(1f), value = "8"){}
            Buttons(modifier = Modifier.weight(1f), value = "9"){}
            Buttons(modifier = Modifier.weight(1f), value = "*"){}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "4"){}
            Buttons(modifier = Modifier.weight(1f), value = "5"){}
            Buttons(modifier = Modifier.weight(1f), value = "6"){}
            Buttons(modifier = Modifier.weight(1f), value = "-"){}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f), value = "1"){}
            Buttons(modifier = Modifier.weight(1f), value = "2"){}
            Buttons(modifier = Modifier.weight(1f), value = "3"){}
            Buttons(modifier = Modifier.weight(1f), value = "+"){}
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(2f), value = "0"){}
            Buttons(modifier = Modifier.weight(1f), value = ","){}
            Buttons(modifier = Modifier.weight(1f), value = "="){}
        }
    }
}

@Composable
private fun Buttons(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = CalculatorViewModel(),
    value: String,
    onClick:(String)-> Unit
) {
    val color = viewModel.changeColor(value)
    Card(
        modifier= Modifier
            .padding(3.dp)
            .then(modifier), shape = RoundedCornerShape(0),
        colors = CardDefaults.cardColors(color.backGround),
        onClick = {onClick(value)}
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = value, color = color.textColor)
        }
    }
}