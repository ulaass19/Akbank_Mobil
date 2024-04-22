package com.example.akbankmobil.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.akbankmobil.MainActivity
import com.example.akbankmobil.R
import com.example.akbankmobil.common.RoundedImageChangeLanguage
import com.example.akbankmobil.common.RoundedImageFooterLogin
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@SuppressLint("NewApi")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(
    navController: NavController
) {

    val currentDateTime = LocalDateTime.now()

    val context = LocalContext.current

    // Zamanı biçimlendir
    val formatter = DateTimeFormatter.ofPattern("HH")
    val formattedDateTime = currentDateTime.format(formatter)
    val timer = formattedDateTime.toInt()

    val tabItems = listOf(
        TabItem(
            title = stringResource(id = R.string.individual),
            buttonTextRed = stringResource(id = R.string.individual_login),
            buttonTextWhite = stringResource(id = R.string.credit_card_info)
        ),
        TabItem(
            title = stringResource(id = R.string.Institutional),
            buttonTextRed = stringResource(id = R.string.Institutional_login),
            buttonTextWhite = stringResource(id = R.string.credit_card_info)
        )
    )

    var selectedTabIndexed by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        tabItems.size
    }

    val appLanguage = remember { mutableStateOf(false) }

    LaunchedEffect(selectedTabIndexed){
        pagerState.animateScrollToPage(selectedTabIndexed)
    }

    LaunchedEffect(pagerState.currentPage,pagerState.isScrollInProgress){
        if (!pagerState.isScrollInProgress) {
            selectedTabIndexed = pagerState.currentPage
        }
    }

    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndexed,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.Red,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndexed])
                )
            }
        ) {

            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index==selectedTabIndexed,
                    onClick = {
                        selectedTabIndexed = index
                    },
                    text = {
                        Text(
                            text = item.title,
                            color = Color.Black
                        )
                    },
                    modifier = Modifier.width(150.dp)
                ) 
            }

        }

        Spacer(modifier = Modifier.height(96.dp))
        
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {index ->

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = when (timer) {
                        in 6..12 -> stringResource(id = R.string.good_morning)
                        in 12..17 -> stringResource(id = R.string.good_day)
                        in 18..21 -> stringResource(id = R.string.good_evening)
                        else -> stringResource(id = R.string.good_night)
                    }, fontSize = 32.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, lineHeight = 40.sp
                )
                
                Spacer(modifier = Modifier.size(96.dp))

                Column(
                    //verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(24.dp)
                ) {
                    Button(
                        onClick = {
                            navController.navigate("tc_login")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.dark_red)
                        ),
                        modifier = Modifier
                            .width(270.dp)
                            .height(45.dp)
                    ) {
                        Text(
                            text = tabItems[index].buttonTextRed,
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    }

                    Spacer(modifier = Modifier.size(8.dp))

                    OutlinedButton(
                        onClick = {
                            navController.navigate("register_with_tc")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.white)
                        ),
                        border = BorderStroke(2.dp, colorResource(id = R.color.red)),
                        modifier = Modifier
                            .width(270.dp)
                            .height(45.dp)
                    ) {
                        Text(
                            text = tabItems[index].buttonTextWhite,
                            color = colorResource(id = R.color.dark_red),
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    }

                    Spacer(modifier = Modifier.size(48.dp))

                    Box(
                        modifier = Modifier.clickable {
                            appLanguage.value = !appLanguage.value
                            if (!appLanguage.value) setLanguage(context = context,"Turkey","tr") else setLanguage(context,"English","en")
                    })
                    {
                        RoundedImageChangeLanguage(
                            painter = if (!appLanguage.value) painterResource(id = R.drawable.turkey) else painterResource(id = R.drawable.england_circular),
                            contentDescription = if (!appLanguage.value) "Turkey Flag" else "England Flag",
                            title = if (!appLanguage.value) "Türkçe" else "English",
                        )
                    }
                }
                
                Spacer(modifier = Modifier.weight(1f))

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(colorResource(id = R.color.dark_red))
                        .fillMaxWidth()
                        .height(180.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .background(colorResource(id = R.color.dark_red))
                            .fillMaxWidth()
                            .height(180.dp)
                    ) {

                        Box(
                            modifier = Modifier.clickable {
                                navController.navigate("applications_screen")
                            }.background(Color.Transparent)
                        ) {
                            RoundedImageFooterLogin(
                                painter = painterResource(id = R.drawable.add_file),
                                contentDescription = "başvurular",
                                title = stringResource(id = R.string.credit_and_card_applications)
                            )
                        }

                        RoundedImageFooterLogin(
                            painter = painterResource(id = R.drawable.exchange),
                            contentDescription = "döviz",
                            title = stringResource(id = R.string.exchange)
                        )

                        RoundedImageFooterLogin(
                            painter = painterResource(id = R.drawable.museum),
                            contentDescription = "Müze",
                            title = stringResource(id = R.string.nearest_akbank)
                        )

                    }

                    Text(
                        text = "1 USD = 33,8700",
                        color = colorResource(id = R.color.white),
                        fontSize = 6.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                }

            }

        }
        
        
    }
}

data class TabItem(
    val title:String,
    var buttonTextRed:String,
    var buttonTextWhite:String
)

fun setLanguage(context: Context, language: String, languageCode: String) {
    val sharedPreferences = context.getSharedPreferences("hello",MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("language", language)
    editor.apply()

    // Locale ve Configuration ayarlarını güncelleme
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val configuration = Configuration()
    configuration.setLocale(locale)
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)

    restartActivity(context)

}

private fun restartActivity(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    context.startActivity(intent)
    /*context.finish()*/
}