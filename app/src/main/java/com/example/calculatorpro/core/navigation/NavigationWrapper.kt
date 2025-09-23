package com.example.calculatorpro.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.calculatorpro.core.EndActivity
import com.example.calculatorpro.core.StarActivity

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = STAR) {
        composable<STAR> {
            StarActivity { name -> navController.navigate(END(text = name)) }
        }
        composable<END> { backStackEntry ->
            EndActivity(
                text = backStackEntry.toRoute<END>().text,
                navToJoker = {navController.navigate(JOKER)}
            ) {
                //navController.popBackStack() ->
                //navController.navigateUp() ->
                // solo lo uso si quiero navegar 1 pantalla atras pero
                // si quiero volver a la primera pantalla sera asi:
                navController.navigate(STAR) {
                    popUpTo<STAR> { inclusive = true }
                }
            }
        }
        composable <JOKER>{ Joker() }
    }
}