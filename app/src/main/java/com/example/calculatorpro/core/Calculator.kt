package com.example.calculatorpro.core

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {},
        content = { innerPadding ->
            Content(modifier = modifier.padding(innerPadding))
        }
    )
}

@Composable
private fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxSize()
                .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text("Text")
        }
        ExampleButtons(modifier = Modifier
            .weight(0.6f)
            .fillMaxSize())
    }
}

@Composable
fun ExampleButtons(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(color = Color.Green)) {
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            Buttons(modifier = Modifier.weight(2f))
            Buttons(modifier = Modifier.weight(1f))
            Buttons(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun Buttons(modifier: Modifier = Modifier) {
    Card(
        modifier= Modifier
            .padding(1.dp)
            .then(modifier),
        onClick = {}
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "?")
        }
    }
}