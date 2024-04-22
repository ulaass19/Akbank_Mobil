package com.example.akbankmobil.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.akbankmobil.R
import com.example.akbankmobil.ui.theme.AkbankMobilTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetermineMoney(
    navController:NavController,
    username:String,
    balance:String,
) {

    val myFont = FontFamily(
        Font(R.font.kinetika_semi_bold)
    )

    val balanceState = remember {
        mutableStateOf("")
    }

    val desc = remember {
        mutableStateOf("")
    }


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
            verticalAlignment = Alignment.CenterVertically,
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
                "Para gönder",
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
        }

        Text(
            text = username,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            style = TextStyle(
                fontFamily = myFont
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Garanti BBVA",
            fontSize = 16.sp,
            color = colorResource(id = R.color.placeholder_text_color),
            fontWeight = FontWeight.SemiBold,
            style = TextStyle(
                fontFamily = myFont
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 96.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = balanceState.value,
                onValueChange = {
                    balanceState.value = it
                },
                placeholder = {
                    Text(
                        "0,00 TL",
                        color = colorResource(id = R.color.placeholder_text_color),
                        fontSize = 48.sp,
                        style = TextStyle(
                            fontFamily = myFont
                        )
                    )
                },
                modifier = Modifier.padding(top = 32.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(fontSize = 48.sp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.white)
                ),
            ) {

                Text(
                    text = "Gönderen\nYeşilpınar (0698-0201077)",
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    color = colorResource(id = R.color.supporting_textfield_color),
                    lineHeight = 20.sp
                )

                Text(
                    text = balance,
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    color = colorResource(id = R.color.supporting_textfield_color),
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 24.dp, end = 24.dp),
                    color = colorResource(id = R.color.divider_color)
                )

                Text(
                    "Alıcı",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    lineHeight = 15.sp
                )

                Text(
                    "TR 12345678909",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 8.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                )

                Text(
                    "TÜRKİYE GARANTİ BANKASI A.Ş.",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 8.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 24.dp, end = 24.dp),
                    color = colorResource(id = R.color.divider_color)
                )

                Text(
                    "Transfer Tipi",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    lineHeight = 15.sp
                )

                Text(
                    "Bireysel ödeme",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 8.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 24.dp, end = 24.dp),
                    color = colorResource(id = R.color.divider_color)
                )

                Text(
                    "Açıklama",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    lineHeight = 15.sp
                )

                TextField(
                    value = desc.value,
                    onValueChange = {
                        desc.value = it
                    },
                    placeholder = {
                        Text(
                            "Opsiyonel",
                            color = colorResource(id = R.color.placeholder_text_color),
                            fontSize = 12.sp,
                            style = TextStyle(
                                fontFamily = myFont
                            )
                        )
                    },
                    modifier = Modifier.padding(top = 0.dp, end = 0.dp, start = 16.dp, bottom = 0.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    maxLines = 1
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val balanceValue = balanceState.value.toDouble()
                    val balanceInt = balance.toDouble()

                    val availableBalance = balanceInt-balanceValue

                    val balanceValueString = balanceValue.toString()
                    val balanceAvailableStringValue = availableBalance.toString()

                    Log.e("bakiyeKalan",availableBalance.toString())

                    if (availableBalance<0) {
                        Log.e("msg","Bakiye yetersiz")

                    } else {
                        navController.navigate("succes_money_sending/${username}/${balanceAvailableStringValue}/${balanceValueString}")
                    }

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (balanceState.value=="") colorResource(id = R.color.inaktif_button_bg) else colorResource(
                        id = R.color.dark_red
                    )
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Devam",
                    color = colorResource(id = R.color.white)
                )
            }

        }

    }
    
}

@Preview(showBackground = true)
@Composable
fun DetermineMoneyPreview(){

    val navController = rememberNavController()

    AkbankMobilTheme {
        DetermineMoney(navController = navController, username = "", balance = "")
    }

}