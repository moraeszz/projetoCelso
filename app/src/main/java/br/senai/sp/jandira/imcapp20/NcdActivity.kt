package br.senai.sp.jandira.imcapp20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_ncd.*

class NcdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ncd)

        val buttonCalcular: Button = findViewById(R.id.button_calcular_ncd)

        val editTextPeso : EditText = findViewById(R.id.edit_text_qual_peso)
        val editTextIdade: EditText = findViewById(R.id.edit_text_qual_idade)
        val generoMasculino:  RadioButton = findViewById(R.id.edit_text_masculino)
        val generoFeminino:  RadioButton = findViewById(R.id.edit_text_feminino)
        val atividadeLeve:  RadioButton = findViewById(R.id.edit_text_nivel_leve)
        val atividadeModerada:  RadioButton = findViewById(R.id.edit_text_nivel_moderado)
        val atividadeIntensa:  RadioButton = findViewById(R.id.edit_text_nivel_intenso)
        val editTextAltura: EditText = findViewById(R.id.edit_text_qual_altura)

        var sexo = 0
        var atividade = 0
        buttonCalcular.setOnClickListener {

            if (edit_text_qual_peso.text.isEmpty()) {
                edit_text_qual_peso.error = "Voce não me disse o seu peso"
            }
            if (edit_text_qual_idade.text.isEmpty()) {
                edit_text_qual_idade.error = "Voce não me disse a sua idade"
            }


            if (edit_text_qual_peso.text.isNotEmpty() && edit_text_qual_idade.text.isNotEmpty()) {
                val peso: Double = edit_text_qual_peso.text.toString().toDouble()
                val altura: Double = edit_text_qual_idade.text.toString().toDouble()



                val intent = Intent(this, ResultadoNcdActivity::class.java)

                if (generoMasculino.isChecked) {
                    sexo = 1
                } else if (generoFeminino.isChecked) {
                    sexo = 2
                }


                if (atividadeLeve.isChecked) {
                    atividade = 1
                } else if (atividadeModerada.isChecked) {
                    atividade = 2
                } else if (atividadeIntensa.isChecked) {
                    atividade = 3
                }


                intent.putExtra("sexo", sexo.toString().toInt())
                intent.putExtra("atividade", atividade.toString().toInt())
                intent.putExtra("peso", editTextPeso.text.toString().toDouble())
                intent.putExtra("idade", editTextIdade.text.toString().toInt())
                startActivity(intent)

            }
        }
    }
}