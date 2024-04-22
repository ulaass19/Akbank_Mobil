package com.example.akbankmobil.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.os.Environment
import android.os.ParcelFileDescriptor
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.akbankmobil.R
import com.example.akbankmobil.common.RoundedImageSuccesPage
import com.example.akbankmobil.generator.PDFGenerator
import com.example.akbankmobil.ui.theme.AkbankMobilTheme
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.time.LocalDateTime
import android.util.Base64
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout

@Composable
fun SuccessSendMoneyScreen(
    navController: NavController,
    personSentUsername:String,
    availableBalance:String,
    balanceValueString : String
) {

    val myFont = FontFamily(
        Font(R.font.kinetika_semi_bold)
    )

    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bg)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.green_success),
            contentDescription = "Green Tik",
            modifier = Modifier
                .size(296.dp)
                .padding(top = 48.dp)
        )

        Spacer(modifier = Modifier.size(64.dp))
        
        Text(
            text = "${personSentUsername} isimli alıcıya\nbaşarılı para transferi\ngerçekleştirdin",
            fontSize = 26.sp,
            color = colorResource(id = R.color.black),
            style = TextStyle(
                fontFamily = myFont
            ),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            text = "Transferin durumunu G***** Bankası\nplatformundan öğrenebilirsiniz",
            fontSize = 14.sp,
            color = colorResource(id = R.color.supporting_textfield_color),
            style = TextStyle(
                fontFamily = myFont
            ),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.size(32.dp))

        Box(
            modifier = Modifier
                .clickable {
                    val pdfFile = File(context.filesDir, "example.pdf")

                    PDFGenerator.createPDF(context, personSentUsername, balanceValueString)



                }
                .background(Color.Transparent)
        ) {
            RoundedImageSuccesPage(
                painter = painterResource(id = R.drawable.receipt_red),
                contentDescription = "başvurular",
                title = stringResource(id = R.string.credit_and_card_applications)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                      navController.navigate("LoginScreen")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.dark_red)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Tamam",
                color = colorResource(id = R.color.white)
            )
        }

    }
}

private fun viewPDF(context: Context, file: File) {
    val pdfFileUri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(pdfFileUri, "application/pdf")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(intent)
}


fun openLocalFile(context: Context, file: File) {
    val fileUri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(fileUri, getMimeType(file.absolutePath))
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    context.startActivity(intent)
}

private fun getMimeType(url: String): String {
    return if (url.contains(".pdf")) {
        "application/pdf"
    } else if (url.contains(".txt")) {
        "text/plain"
    } else {
        "*/*"
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSucces() {

    val navController = rememberNavController()

    AkbankMobilTheme {
        SuccessSendMoneyScreen(navController = navController, personSentUsername = "Ulaş Çiçek","","")
    }
}