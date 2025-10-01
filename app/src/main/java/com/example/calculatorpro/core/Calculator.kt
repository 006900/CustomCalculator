package com.example.calculatorpro.core

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.forEach
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorpro.ui.theme.Primary

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier, viewModel: CalculatorViewModel,navigation: () -> Unit) {
    Scaffold(
        topBar = {NavigationTopBar { navigation() }},
        content = { innerPadding ->
            Content(
                modifier = modifier
                    .background(Primary)
                    .padding(innerPadding), viewModel = viewModel
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationTopBar(modifier: Modifier = Modifier, navigation: () -> Unit) {
    TopAppBar(
        title = { Text("Calculator") },
        actions = {
            IconButton(onClick = { navigation() }
            ) {
                Icon(imageVector = Icons.Default.Calculate, contentDescription = null)
            }
        }
    )
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
private fun Content(modifier: Modifier = Modifier, viewModel: CalculatorViewModel) {
    val displayText = viewModel.state
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(4f)
                .fillMaxWidth()
                .padding(10.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(horizontalAlignment = Alignment.End) {
                Text(displayText.text, fontSize = 25.sp)
                Text(displayText.result, fontSize = 15.sp, color = Color.LightGray)
            }
        }
        Sexo(
            modifier = Modifier
                .weight(6f)
                .fillMaxSize(),viewModel = viewModel
        )
    }
}

@Composable
fun Sexo(modifier: Modifier = Modifier,viewModel: CalculatorViewModel) {
    val keys = listOf(
        "c", "/", "%","⌫",
        "7", "8", "9","*",
        "4", "5", "6","-",
        "1", "2", "3","+",
        "0", ",", "="
    )

    Column(
        modifier = modifier.background(Color.hsl(240f, 0.1f, 0.2f)) // Un fondo azul oscuro
    ) {
        // Filas de botones
        val chunkedKeys = keys.chunked(4)

        chunkedKeys.forEachIndexed { rowIndex, rowKeys ->
            Row(
                modifier = Modifier
                    .weight(1f) // Cada fila de botones toma un peso igual
                    .fillMaxWidth()
                    .background(Color.hsl(240f, 0.1f, 0.25f)), // Un poco más claro que el fondo general
                horizontalArrangement = Arrangement.spacedBy(2.dp) // Espacio reducido entre botones
            ) {
                // Caso especial para la última fila que contiene "0", ",", "="
                if (rowIndex == chunkedKeys.size - 1 && rowKeys.contains("0")) {

                    rowKeys.forEach { keyLabel ->
                        val buttonWeight = when (keyLabel) {
                            "0" -> 2f  // El botón "=" toma el doble de peso
                            else -> 1f // "0" y "," toman peso normal
                        }
                        Buttons(modifier = Modifier.weight(buttonWeight),value = keyLabel) { if (keyLabel == "=") viewModel.result() else viewModel.changeText(it) }
                    }
                } else if (rowIndex == 0 && rowKeys.contains("c")){

                    rowKeys.forEach { keyLabel ->
                        val buttonWeight = when (keyLabel) {
                            "0" -> 2f  // El botón "=" toma el doble de peso
                            else -> 1f // "0" y "," toman peso normal
                        }
                        Buttons(modifier = Modifier.weight(buttonWeight),value = keyLabel) { viewModel.clear(it) }
                    }

                }else { // Para todas las otras filas o si la última fila no es la especial
                    rowKeys.forEach { keyLabel ->
                        Buttons(modifier = Modifier.weight(1f), value = keyLabel) { viewModel.changeText(it)}
                    }
                    // Si la fila no está completa y quieres rellenar con espacio vacío
                    // para mantener la alineación con `itemsPerRow = 4`
                    if (rowKeys.size < 4 && !(rowIndex == chunkedKeys.size - 1 && rowKeys.contains("="))) {
                        repeat(4 - rowKeys.size) {
                            Spacer(Modifier.weight(1f)) // Placeholder con peso
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun Buttons(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = CalculatorViewModel(),
    value: String, onClick: (String) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(3.dp)
            .then(modifier), shape = RoundedCornerShape(0),
        onClick = { onClick(value) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = value)
        }
    }
}