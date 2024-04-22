package com.example.akbankmobil.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.akbankmobil.R
import kotlinx.coroutines.delay

@Composable
fun SplashPage(
    navController: NavController,
) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("LoginScreen")
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(colorResource(id = R.color.red))
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.akbank_logo_white),
            contentDescription = stringResource(id = R.string.akbank_white_logo),
            modifier = Modifier
                .height(300.dp)
        )
    }
}

