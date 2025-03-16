package br.edu.fatecpg.leiohm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.leideohm.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtendo as referências das views
        val edtTensao = findViewById<EditText>(R.id.edtTensao)
        val edtResistencia = findViewById<EditText>(R.id.edtResistencia)
        val edtCorrente = findViewById<EditText>(R.id.edtCorrente)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txvResultado)

        btnCalcular.setOnClickListener {
            val tensao = edtTensao.text.toString().toDoubleOrNull()
            val resistencia = edtResistencia.text.toString().toDoubleOrNull()
            val corrente = edtCorrente.text.toString().toDoubleOrNull()

            when {
                tensao == null && resistencia != null && corrente != null -> {
                    val resultado = resistencia * corrente
                    txtResultado.text = "Tensão: $resultado V"
                }
                resistencia == null && tensao != null && corrente != null -> {
                    val resultado = tensao / corrente
                    txtResultado.text = "Resistência: $resultado Ω"
                }
                corrente == null && tensao != null && resistencia != null -> {
                    val resultado = tensao / resistencia
                    txtResultado.text = "Corrente: $resultado A"
                }
                else -> {
                    txtResultado.text = "Por favor, insira dois valores para calcular a variável faltante."
                }
            }
        }
    }
}