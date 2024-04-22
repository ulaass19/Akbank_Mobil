package com.example.akbankmobil.generator

import android.content.Context
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Environment
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object PDFGenerator {
    fun createPDF(context: Context?, textContent: String?,sendingBalance:String?) {
        val pdfDocument = PdfDocument()
        val pageInfo = PageInfo.Builder(300, 600, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas
        val paint = Paint()
        paint.textSize = 12f
        canvas.run {
            paint.textSize = 12f
            drawText("Alıcı Kişinin Bilgileri \n Alıcı kişinin Adı-Soyadı : ${textContent}\n", 10f, 10f, paint)
            drawText("ALıcının Alacağı Miktar : ${sendingBalance}",40f,40f,paint)
        }
        pdfDocument.finishPage(page)

        // Save PDF to application directory
        val directory = context?.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
        val filePath = File(directory, "example.pdf")
        try {
            pdfDocument.writeTo(FileOutputStream(filePath))
            Toast.makeText(context, "PDF saved to " + filePath.absolutePath, Toast.LENGTH_LONG)
                .show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }
        pdfDocument.close()
    }
}

