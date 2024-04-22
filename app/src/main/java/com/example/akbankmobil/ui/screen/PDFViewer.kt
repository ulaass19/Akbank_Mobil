package com.example.akbankmobil.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import android.graphics.Bitmap

@Composable
fun PDFViewer(images: List<Bitmap>) {
    LazyColumn {
        items(images.size) { index ->
            val bitmap = images[index]
            val imageBitmap: ImageBitmap = bitmap.asImageBitmap()
            Image(
                bitmap = imageBitmap,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
