package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val editPeso : EditText = findViewById(R.id.edittext_peso)
        val editAltura: EditText = findViewById(R.id.edittext_altura)


        btnCalcular.setOnClickListener {

            val alturaStr = editAltura.text.toString()
            val pesoStr = editPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
            val altura : Float = alturaStr.toFloat()
            val peso : Float = pesoStr.toFloat()

            val AlturaFinal: Float = altura * altura
            val PesoFinal: Float = peso
            val result: Float = peso / AlturaFinal



            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)

        } else
            Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
        }

    }
}