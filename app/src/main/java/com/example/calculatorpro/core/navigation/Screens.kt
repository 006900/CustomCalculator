package com.example.calculatorpro.core.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import org.mozilla.javascript.ast.Name

@Serializable
object STAR

@Serializable
data class END(val text: String)

@Serializable
object JOKER
