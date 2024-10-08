package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "Resultctivity.KEY_IMC"

class Resultctivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultctivity)

        val result = intent.getFloatExtra("KEY_RESULT_IMC", 0f)

        val tvResult = findViewById<TextView>(R.id.tv_resultado)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classificacao: String
        val cor: Int
            if (result <= 18.5f) {
                classificacao = "MAGREZA"
                cor = Color.RED
        } else if (result in 18.5f..24.9f) {
                classificacao = "NORMAL"
                cor = Color.GREEN
        } else if (result in 25f..29.9f) {
                classificacao = "SOBREPESO"
                cor = Color.YELLOW
        } else if (result in 30f..39.9f) {
                classificacao = "OBESIDADE"
                cor = Color.RED
        } else {
                classificacao = "OBESIDADE GRAVE"
                cor = Color.RED
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(cor)
    }
}
