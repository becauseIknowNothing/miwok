package com.lovish.miwok

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.numbers).setOnClickListener{
            val i = Intent(this, NumbersActivity::class.java)
            startActivity(i)
        }
        findViewById<TextView>(R.id.phrases).setOnClickListener{
            val i = Intent(this, PhrasesActiivity::class.java)
            startActivity(i)
        }
        findViewById<TextView>(R.id.family).setOnClickListener {
            val i = Intent(this, FamilyActivity::class.java)
            startActivity(i)
        }
        findViewById<TextView>(R.id.colors).setOnClickListener {
            val i = Intent(this, ColorsActivity::class.java)
            startActivity(i)
        }


    }
}
