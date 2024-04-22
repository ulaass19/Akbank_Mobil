package com.example.akbankmobil.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.akbankmobil.R
import com.example.akbankmobil.common.RoundedImageBanner
import com.example.akbankmobil.common.RoundedImageOperations
import com.example.akbankmobil.ui.theme.AkbankMobilTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
@Composable
fun HomeScreen(
    navController: NavController
) {

    val myFont = FontFamily(
        Font(R.font.kinetika_semi_bold)
    )

    val currentDateTime = LocalDateTime.now()

    val ballance = 1000000.00

    val scrollState = rememberScrollState()

    val formatter = DateTimeFormatter.ofPattern("HH")
    val formattedDateTime = currentDateTime.format(formatter)
    val timer = formattedDateTime.toInt()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bg))
            .verticalScroll(scrollState)
    ) {
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(colorResource(id = R.color.dark_red))
        ) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = when (timer) {
                        in 6..12 -> stringResource(id = R.string.good_morningg)
                        in 12..17 -> stringResource(id = R.string.good_dayy)
                        in 18..21 -> stringResource(id = R.string.good_eveningg)
                        else -> stringResource(id = R.string.good_nightt)
                    }, fontSize = 18.sp, style = TextStyle(
                        fontFamily = myFont
                    ),
                    color = colorResource(id = R.color.name_surname),
                    modifier = Modifier.padding(start = 18.dp, top = 18.dp)
                )
                
                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    text = "Yaptığın 2 harcamanın\niadesi yattı!",
                    color = Color.White,
                    fontSize = 21.sp,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    modifier = Modifier.padding(start = 18.dp, top = 18.dp)
                )

                Spacer(modifier = Modifier.size(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(start = 18.dp, top = 18.dp),
                        border = BorderStroke(2.dp, Color.White)
                    ) {

                        Text(
                            text = "Detaylar",
                            fontSize = 16.sp,
                            style = TextStyle(
                                fontFamily = myFont
                            ),
                            color = colorResource(id = R.color.white)
                        )

                    }
                    
                    Spacer(modifier = Modifier.size(18.dp))

                    Box(
                        modifier = Modifier.padding(top = 12.dp)
                    ) {
                        RoundedImageBanner(
                            painter = painterResource(id = R.drawable.like),
                            contentDescription = "Like Icon"
                        )
                    }

                }

            }
            
        }
        
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Hesaplar ve kartlar",
                color = colorResource(id = R.color.placeholder_text_color),
                style = TextStyle(
                    fontFamily = myFont
                ),
                modifier = Modifier.padding(start = 18.dp, top = 32.dp),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Tümü",
                color = colorResource(id = R.color.dark_red),
                style = TextStyle(
                    fontFamily = myFont
                ),
                modifier = Modifier.padding(end = 24.dp, top = 32.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.Underline
            )


        }
        
        Spacer(modifier = Modifier.size(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white)
            ),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Row {
                    Text(
                        text = "Yeşilpınar",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(start = 18.dp, top = 12.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))


                    Icon(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = "The more",
                        modifier = Modifier.padding(end = 18.dp, top = 12.dp)
                    )

                }

                Text(
                    text = "0698-0201077",
                    color = colorResource(id = R.color.placeholder_text_color),
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    modifier = Modifier.padding(start = 18.dp, top = 12.dp)
                )

                Text(
                    text = "Kullanılabilir bakiye",
                    color = colorResource(id = R.color.placeholder_text_color),
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    modifier = Modifier.padding(start = 18.dp, top = 12.dp),
                    fontSize = 16.sp
                )

                Row(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text(
                        text = ballance.toString(),
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(start = 18.dp, top = 4.dp),
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Vadesiz",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(end = 18.dp, top = 4.dp),
                        fontSize = 18.sp
                    )

                }

                Spacer(modifier = Modifier.size(24.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                    color = colorResource(id = R.color.dark_red) // Opsiyonel: Ayırıcı rengini belirleyebilirsiniz
                )

            }
        }


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white)
            ),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Row {
                    Text(
                        text = "Axess Gold MC D",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(start = 18.dp, top = 12.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))


                    Icon(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = "The more",
                        modifier = Modifier.padding(end = 18.dp, top = 12.dp)
                    )

                }

                Text(
                    text = "**** 2634",
                    color = colorResource(id = R.color.placeholder_text_color),
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    modifier = Modifier.padding(start = 18.dp, top = 12.dp)
                )

                Text(
                    text = "Kullanılabilir bakiye",
                    color = colorResource(id = R.color.placeholder_text_color),
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    modifier = Modifier.padding(start = 18.dp, top = 12.dp),
                    fontSize = 16.sp
                )

                Row(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text(
                        text = ballance.toString(),
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(start = 18.dp, top = 4.dp),
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "axess",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(end = 18.dp, top = 4.dp),
                        fontSize = 18.sp
                    )

                }

                Spacer(modifier = Modifier.size(24.dp))

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                    color = colorResource(id = R.color.yellow) // Opsiyonel: Ayırıcı rengini belirleyebilirsiniz
                )

            }
        }

        Text(
            text = "Yatırım ve Döviz",
            color = colorResource(id = R.color.placeholder_text_color),
            style = TextStyle(
                fontFamily = myFont
            ),
            modifier = Modifier.padding(start = 18.dp, top = 32.dp),
            fontSize = 16.sp
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white)
            ),
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {

                Text(
                    text = "Yatırımlarım",
                    color = colorResource(id = R.color.placeholder_text_color),
                    style = TextStyle(
                        fontFamily = myFont
                    ),
                    modifier = Modifier.padding(start = 18.dp, top = 12.dp),
                    fontSize = 16.sp
                )
                
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = "The more",
                    modifier = Modifier.padding(end = 18.dp, top = 12.dp)
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Yatırım işlemleri yap ve\nYatırımlarını takip et",
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(start = 18.dp, top = 12.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = "Yatırımlarını görüntüle",
                        style = TextStyle(
                            fontFamily = myFont
                        ),
                        modifier = Modifier.padding(start = 18.dp, top = 12.dp, bottom = 12.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.dark_red),
                        textDecoration = TextDecoration.Underline
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.dolat_turkish_money_no_bg),
                    contentDescription = "Dolar turkish money",
                    modifier = Modifier.height(86.dp)
                )
            }



        }

        Text(
            text = "İşlemler",
            color = colorResource(id = R.color.placeholder_text_color),
            style = TextStyle(
                fontFamily = myFont
            ),
            modifier = Modifier.padding(start = 18.dp, top = 32.dp),
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.size(16.dp))

        Box(
            modifier = Modifier.padding(12.dp)
                .clickable {
                    navController.navigate("send_money/${ballance}")
                }
        ){
            RoundedImageOperations(
                painter = painterResource(id = R.drawable.money_transfer),
                contentDescription = "döviz",
                title = "Para Transferi"
            )
        }

        Box(modifier = Modifier.padding(12.dp)){
            RoundedImageOperations(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "döviz",
                title = "Başvuru ve nakit ihtiyaçlar"
            )
        }

        Box(modifier = Modifier.padding(12.dp)){
            RoundedImageOperations(
                painter = painterResource(id = R.drawable.credit),
                contentDescription = "döviz",
                title = "Kredi işlemleri"
            )
        }

        Box(modifier = Modifier.padding(12.dp)){
            RoundedImageOperations(
                painter = painterResource(id = R.drawable.defender),
                contentDescription = "döviz",
                title = "Sigortalar ve bireysel emeklilik"
            )
        }

        Box(modifier = Modifier.padding(12.dp)){
            RoundedImageOperations(
                painter = painterResource(id = R.drawable.rise),
                contentDescription = "döviz",
                title = "Tüm varlıklar"
            )
        }

        Box(modifier = Modifier.padding(12.dp)){
            RoundedImageOperations(
                painter = painterResource(id = R.drawable.price_tag),
                contentDescription = "döviz",
                title = "Kampanyalar"
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){

    val navController = rememberNavController()

    AkbankMobilTheme {
        HomeScreen(navController = navController)
    }
}