package com.example.calculatorpro.core

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CurrencyConverterScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {},
        content = {
            Content(Modifier.navigationBarsPadding().statusBarsPadding())
        }
    )
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    val keys = listOf(
        "7", "8", "9",
        "4", "5", "6",
        "1", "2", "3",
        ",", "0", "⌫"
    )
    Column (modifier = modifier.fillMaxSize().background(Color.Blue)){
        Box(modifier = Modifier
            .weight(5f)
            .fillMaxSize()
            .background(Color.Red)){

        }
        keys.chunked(3).forEach { alan->
            Row (modifier= Modifier.weight(1.25f).fillMaxSize().background(Color.Green)){
               alan.forEach { text ->
                   BTC(modifier= Modifier.weight(1f),text = text)
               }
            }
        }
    }
}


@Composable
fun BTC(modifier: Modifier = Modifier,text: String) {
    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
            .then(modifier),
        shape = RoundedCornerShape(0)
    ){
        Box(
            modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text)
        }
    }
}