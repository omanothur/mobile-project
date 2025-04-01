package com.example.mobile_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var alturaEdit: EditText
    private lateinit var pesoEdit: EditText
    private lateinit var button: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            if (validationinput()){
                val altura: Double = alturaEdit.text.toString().toDouble()
                val peso: Double = pesoEdit.text.toString().toDouble()
                val imc = peso / (altura * altura)
                when{
                    imc < 18.5 -> resultText.text = getString(R.string.underweight)
                    imc in 18.5..24.9 -> resultText.text = getString(R.string.normal)
                    imc in 25.0..29.9 -> resultText.text = getString(R.string.overweight)
                    imc in 30.0..34.9 -> resultText.text = getString(R.string.obesityI)
                    imc in 35.0..39.9 -> resultText.text = getString(R.string.obesityII)
                    else -> resultText.text = getString(R.string.obesityIII)
                }
            }
        }


    }

    private fun validationinput(): Boolean {
        if(alturaEdit.text.isEmpty() || pesoEdit.text.isEmpty()){
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}