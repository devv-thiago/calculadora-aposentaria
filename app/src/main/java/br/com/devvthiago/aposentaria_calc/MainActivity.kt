package br.com.devvthiago.aposentaria_calc

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_idade = findViewById<EditText>(R.id.txt_idade)
        val calcButton = findViewById<Button>(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        // definindo itens do spinner
        sexo.adapter = ArrayAdapter<String> (this,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino"))

        calcButton.setOnClickListener(View.OnClickListener {
            val sexoEscolhido = sexo.selectedItem as String
            val idadeUsuario = txt_idade.text.toString().toInt()

            var resultado: Int

            if (sexoEscolhido == "Masculino") {
                resultado = 65 - idadeUsuario
            } else {
                resultado = 60 - idadeUsuario
            }

            txt_resultado.text = "Faltam $resultado anos para você se aposentar."
        })
    }
}
