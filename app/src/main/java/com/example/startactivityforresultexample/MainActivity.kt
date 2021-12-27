package com.example.startactivityforresultexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.io.File
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRead = findViewById<Button>(R.id.btn_read)

        btnRead.setOnClickListener {

             val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_MIME_TYPES, intent.type)
            startActivityForResult(intent, FILE_PICKER_ID)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FILE_PICKER_ID && resultCode == Activity.RESULT_OK){
            val dest = data?.data

            var ivImage = findViewById<ImageView>(R.id.image_view)
            ivImage.setImageURI(dest)

        }

    }


    companion object{
        const val FILE_PICKER_ID: Int = 12 //this is request code
    }
}