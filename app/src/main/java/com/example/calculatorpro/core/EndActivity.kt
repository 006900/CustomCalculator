package com.example.calculatorpro.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun EndActivity(
    modifier: Modifier = Modifier,
    text: String,
    navToJoker:()-> Unit,
    onClick:()-> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = text, fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Button(onClick = {onClick()}) {
            Text(text = "back to star")
        }
        Button(onClick = {navToJoker()}) {
            Text(text = "nav to joker")
        }
    }
}