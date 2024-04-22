package com.example.akbankmobil.ui.screen


import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.akbankmobil.database.MyDatabaseClass
import com.example.akbankmobil.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginWithTc(
    navController: NavController
) {

    val tcOrClientNumber = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }


    val myFont = FontFamily(
        Font(R.font.kinetika_semi_bold)
    )

    val context = LocalContext.current

    val db = MyDatabaseClass.databaseConnect(context)!!

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
            
            Spacer(modifier = Modifier.weight(1/2f))

            Text(
                text = stringResource(id = R.string.Institutional_login),
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

                Text(
                    text = stringResource(id = R.string.client_or_tr_id_no),
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    )
                )

                TextField(
                    value = tcOrClientNumber.value,
                    onValueChange = {
                                    tcOrClientNumber.value = it
                    },
                    placeholder = { 
                        Text(
                            stringResource(id = R.string.client_or_tr_id_no),
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
                    )
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 24.dp, end = 24.dp),
                    color = colorResource(id = R.color.divider_color) // Opsiyonel: Ayırıcı rengini belirleyebilirsiniz
                )

                Text(
                    text = stringResource(id = R.string.akbank_password),
                    color = colorResource(id = R.color.supporting_textfield_color),
                    modifier = Modifier.padding(top = 16.dp, end = 0.dp, start = 32.dp, bottom = 0.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    )
                )

                TextField(
                    value = password.value,
                    onValueChange = {
                        password.value=it
                    },
                    placeholder = {
                        Text(
                            stringResource(id = R.string.six_digits_number),
                            color = colorResource(id = R.color.placeholder_text_color),
                            style = TextStyle(
                                fontFamily = myFont
                            ),
                            fontSize = 12.sp
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
                    )
                )

            }
            
            Spacer(modifier = Modifier.size(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.forhet_your_client_number),
                    color = colorResource(id = R.color.dark_red),
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                )
                
                Spacer(modifier = Modifier.weight(1f))
                
                Text(
                    text = stringResource(id = R.string.forget_password),
                    color = colorResource(id = R.color.dark_red),
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val tcNumber = tcOrClientNumber.value.trim()
                    val pass = password.value.trim()

                    if (tcNumber.isBlank() || pass.isBlank()) {
                        Toast.makeText(context, "Lütfen kullanıcı bilgilerinizi giriniz", Toast.LENGTH_LONG).show()
                        return@Button
                    }

                    if (tcNumber.length != 11 || pass.length != 6) {
                        Toast.makeText(context, "Geçersiz giriş bilgileri", Toast.LENGTH_LONG).show()
                        return@Button
                    }

                    CoroutineScope(Dispatchers.Main).launch {
                        val userExists = isUserExists(db, tcNumber, pass)
                        if (!userExists) {
                            Toast.makeText(context, "Başarılı Giriş", Toast.LENGTH_LONG).show()
                            navController.navigate("HomeScreen")
                        } else {
                            Toast.makeText(context, "Başarısız Giriş", Toast.LENGTH_LONG).show()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = if (tcOrClientNumber.value.isBlank() || password.value.isBlank()) R.color.inaktif_button_bg else R.color.dark_red)
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
}

suspend fun isUserExists(myDb: MyDatabaseClass, username: String, password: String): Boolean {
    return withContext(Dispatchers.IO) {
        val count = myDb.kisilerDao().getUserCount(username, password)
        count > 0
    }
}

