package com.example.akbankmobil.ui.screen

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.akbankmobil.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IbanScreen(
    navController: NavController,
    balance:String
) {


    val iban = remember {
        mutableStateOf("")
    }

    val nameSurname = remember {
        mutableStateOf("")
    }


    val myFont = FontFamily(
        Font(R.font.kinetika_semi_bold)
    )

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
                "IBAN",
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f) // Text'i row içinde tam ortalıyor
            )

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white)
            ),
        ) {

            Text(
                text = "IBAN",
                color = colorResource(id = R.color.supporting_textfield_color),
                modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(
                    fontFamily = myFont
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                
                Text(
                    text = "TR",
                    color = colorResource(id = R.color.black),
                    fontSize = 16.sp,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    modifier = Modifier.padding(top = 0.dp, end = 0.dp, start = 24.dp, bottom = 0.dp)
                )
                
                TextField(
                    value = iban.value,
                    onValueChange = {
                        iban.value = it
                    },
                    placeholder = {
                        Text(
                            "Alıcının IBAN'ı",
                            color = colorResource(id = R.color.placeholder_text_color),
                            fontSize = 12.sp,
                            style = TextStyle(
                                fontFamily = myFont
                            )
                        )
                    },
                    modifier = Modifier.padding(top = 0.dp, end = 0.dp, start = 4.dp, bottom = 0.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(start = 24.dp, end = 24.dp),
                color = colorResource(id = R.color.divider_color) // Opsiyonel: Ayırıcı rengini belirleyebilirsiniz
            )

            if (iban.value=="12345678909"){

                nameSurname.value = "Ulaş Çiçek"

                Text(
                    "Ad Soyad",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    )
                )

                TextField(
                    value = nameSurname.value,
                    onValueChange = {
                        nameSurname.value = it
                    },
                    placeholder = {
                        Text(
                            "Alıcının Adı Soyadı",
                            color = colorResource(id = R.color.placeholder_text_color),
                            style = TextStyle(
                                fontFamily = myFont
                            ),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.padding(top = 0.dp, end = 0.dp, start = 16.dp, bottom = 0.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            } else if (iban.value=="12345678908") {

                nameSurname.value = "Mücahit Burak Karaman"

                Text(
                    "Ad Soyad",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    )
                )

                TextField(
                    value = nameSurname.value,
                    onValueChange = {
                        nameSurname.value = it
                    },
                    placeholder = {
                        Text(
                            "Alıcının Adı Soyadı",
                            color = colorResource(id = R.color.placeholder_text_color),
                            style = TextStyle(
                                fontFamily = myFont
                            ),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.padding(top = 0.dp, end = 0.dp, start = 16.dp, bottom = 0.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )

            } else {

                Text(
                    "Ad Soyad",
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    )
                )

                TextField(
                    value = nameSurname.value,
                    onValueChange = {
                        nameSurname.value = it
                    },
                    placeholder = {
                        Text(
                            "Alıcının Adı Soyadı",
                            color = colorResource(id = R.color.placeholder_text_color),
                            style = TextStyle(
                                fontFamily = myFont
                            ),
                            fontSize = 12.sp
                        )
                    },
                    modifier = Modifier.padding(top = 0.dp, end = 0.dp, start = 16.dp, bottom = 0.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )

            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate("determine_money/${nameSurname.value}/${balance}")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (iban.value.length < 26  || nameSurname.value.length > 0 ) colorResource(id = R.color.inaktif_button_bg) else colorResource(id = R.color.dark_red)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Text(
                text = "Giriş",
                color = colorResource(id = R.color.white)
            )

        }

    }

}