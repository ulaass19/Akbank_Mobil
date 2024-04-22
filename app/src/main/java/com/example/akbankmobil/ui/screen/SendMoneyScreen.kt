package com.example.akbankmobil.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.akbankmobil.R
import com.example.akbankmobil.common.RoundedImageSendMoney

@Composable
fun SendMoneyScreen(
    navController:NavController,
    balanceIban:String
) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bg))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(colorResource(id = R.color.dark_red)),
            verticalAlignment = Alignment.CenterVertically, // Row'un dikeyde ortalı olması için
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Spacer(modifier = Modifier.size(16.dp))

            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Back Arrow Icon",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navController.navigate("LoginScreen")
                    },
                tint = Color.White
            )

            Spacer(modifier = Modifier.weight(1/2f))
            

            Text(
                text = stringResource(id = R.string.Institutional_login),
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f) // Text'i row içinde tam ortalıyor
            )

            
            Icon(
                painter = painterResource(
                id = R.drawable.search), 
                contentDescription = "Search Icon",
                tint = colorResource(id = R.color.white),
                modifier = Modifier.padding(end = 18.dp)
            )

        }

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Spacer(modifier = Modifier.size(24.dp))

            Box(
                modifier = Modifier.clickable {
                    navController.navigate("iban/${balanceIban}")
                }
            ) {
                RoundedImageSendMoney(painter = painterResource(id = R.drawable.plus), contentDescription = "", title = "Yeni Kişi")
            }

            Spacer(modifier = Modifier.size(12.dp))

            RoundedImageSendMoney(painter = painterResource(id = R.drawable.group), contentDescription = "", title = "Yeni Grup")
        }

    }
    
}