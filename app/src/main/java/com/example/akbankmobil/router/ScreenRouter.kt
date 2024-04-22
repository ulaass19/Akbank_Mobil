package com.example.akbankmobil.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.akbankmobil.ui.screen.ApplicationsScreen
import com.example.akbankmobil.ui.screen.DetermineMoney
import com.example.akbankmobil.ui.screen.HomeScreen
import com.example.akbankmobil.ui.screen.IbanScreen
import com.example.akbankmobil.ui.screen.LoginScreen
import com.example.akbankmobil.ui.screen.LoginWithTc
import com.example.akbankmobil.ui.screen.RegisterWithTc
import com.example.akbankmobil.ui.screen.SendMoneyScreen
import com.example.akbankmobil.ui.screen.SplashPage
import com.example.akbankmobil.ui.screen.SuccessSendMoneyScreen
import com.example.akbankmobil.ui.screen.WebViewScreen

@Composable
fun ScreenRouter() {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "SplashScreen"){

        composable("SplashScreen"){
            SplashPage(navController)
        }

        composable("LoginScreen"){
            LoginScreen(navController)
        }

        composable("tc_login"){
            LoginWithTc(navController)
        }
        
        composable("applications_screen"){
            ApplicationsScreen(navController = navController)
        }
        
        composable("register_with_tc") {
            RegisterWithTc(navController = navController)
        }

        composable("HomeScreen"){
            HomeScreen(navController)
        }

        composable("send_money/{balance}", arguments = listOf(
            navArgument("balance"){
                type = NavType.StringType
            }
        )){
            it.arguments?.getString("balance")?.let { it1 -> SendMoneyScreen(navController = navController, balanceIban = it1) }
        }

        composable("iban/{balanceIban}", arguments = listOf(
            navArgument("balanceIban"){
                type= NavType.StringType
            }
        )){
            it.arguments?.getString("balanceIban")?.let{it1-> IbanScreen(navController,it1)}
        }

        composable("determine_money/{username}/{balance_determine_money}", arguments = listOf(
            navArgument("username") {
                type = NavType.StringType
            }, navArgument("balance_determine_money"){
                type = NavType.StringType
            }
        )) {backStackEntry->

            val username =
                backStackEntry.arguments?.getString("username") ?: ""

            val balance_determine_money =
                backStackEntry.arguments?.getString("balance_determine_money") ?: ""

            DetermineMoney(navController = navController, username = username, balance = balance_determine_money)

        }

        composable("succes_money_sending/{person_sent_username}/{available_balance}/{balance_value}") {backStackEntry->

            val person_sent_username =
                backStackEntry.arguments?.getString("person_sent_username") ?: ""

            val available_balance =
                backStackEntry.arguments?.getString("available_balance") ?: ""

            val balance_value =
                backStackEntry.arguments?.getString("balance_value") ?: ""

            SuccessSendMoneyScreen(navController = navController, personSentUsername = person_sent_username, availableBalance = available_balance,balance_value)

        }

        composable("webview_screen") {
            WebViewScreen()
        }

    }

}