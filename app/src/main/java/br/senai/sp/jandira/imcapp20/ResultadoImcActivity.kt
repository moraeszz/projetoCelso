package br.senai.sp.jandira.imcapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imc)

       val txtImc: TextView = findViewById(R.id.text_view_imc)
        val txtStatus: TextView = findViewById(R.id.text_view_status)
        val txtStatusRisk: TextView = findViewById(R.id.text_view_frase_status)
        val txtDica: TextView = findViewById(R.id.text_view_dica)

        val peso =  intent.getDoubleExtra("peso", 0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)

        txtImc.text = String.format("%.1f", calcularImc(peso, altura))

        val resultados =  obter_status(calcularImc(peso, altura))

        txtStatus.text = resultados[0]
        txtStatusRisk.text = resultados[1]

        txtDica.text = getDicaDoDia()
    }
}