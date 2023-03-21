package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById<EditText>(R.id.etPeso)
        etAltura = findViewById<EditText>(R.id.etAltura)
    }

    fun calcularIMC(v: View){
        Log.d("IMC", "botão clicado")

        //ENTRADA
        //etPeso = findViewById<EditText>(R.id.etPeso)
        //etAltura = findViewById<EditText>(R.id.etAltura)
        var peso: Double = etPeso.text.toString().toDouble()
        var altura: Double = etAltura.text.toString().toDouble()/100

        //PROCESSAMENTO
        var imc = peso / (altura * altura)
        var situacao =  if(imc < 18.5) "Abaixo do peso"
                        else if (imc >= 18.5 && imc < 25) "Peso normal"
                        else if (imc >= 25 && imc < 30) "Acima do peso"
                        else if (imc >= 30 && imc < 35) "Obesidade I"
                        else if (imc >= 35 && imc < 40) "Obesidade II"
                        else "Obsidade mobida"

        //SAIDA
        findViewById<TextView>(R.id.tvResult)
            .setText("Seu IMC é " + String.format("%.2f", imc) + "\n" + situacao)
    }

}