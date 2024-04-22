package com.example.akbankmobil.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.akbankmobil.R

@Composable
fun ApplicationsScreen(
    navController: NavController
) {

    val myFont = FontFamily(
        Font(R.font.kinetika_semi_bold)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bg))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(colorResource(id = R.color.dark_red)),
            verticalAlignment = Alignment.CenterVertically // Row'un dikeyde ortalı olması için
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

            Spacer(modifier = Modifier.weight(1 / 2f))

            Text(
                text = stringResource(id = R.string.applications),
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f) // Text'i row içinde tam ortalıyor
            )

        }

        Spacer(modifier = Modifier.size(12.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.white)
                ),
            ) {

                Row {
                    Text(
                        text = stringResource(id = R.string.fast_credi_applications),
                        color = colorResource(id = R.color.black),
                        modifier = Modifier.padding(
                            top = 16.dp,
                            end = 0.dp,
                            start = 16.dp,
                            bottom = 16.dp
                        ),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(
                            fontFamily = myFont
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow Back",
                        tint = colorResource(id = R.color.black),
                        modifier = Modifier.padding(top = 16.dp, end = 16.dp)
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 13.dp, end = 13.dp),
                    color = colorResource(id = R.color.divider_color) // Opsiyonel: Ayırıcı rengini belirleyebilirsiniz
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.credit_card_applications),
                        color = colorResource(id = R.color.black),
                        modifier = Modifier.padding(
                            top = 16.dp,
                            end = 0.dp,
                            start = 16.dp,
                            bottom = 16.dp
                        ),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(
                            fontFamily = myFont
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow Back",
                        tint = colorResource(id = R.color.black),
                        modifier = Modifier.padding(top = 8.dp, end = 16.dp)
                    )
                }

            }

        }

    }

}