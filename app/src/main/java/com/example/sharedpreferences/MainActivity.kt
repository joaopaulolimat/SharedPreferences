package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adicionar listener de click no botao
        btnSalvar.setOnClickListener(View.OnClickListener {

            // instancia um container para local storage chamado saudacao no modo privado
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

            // trazer um editor para modificar o shared preferences
            val editor = saudacaoPersistencia.edit()

            // putString guarda um valor (ex.: txtNome.text.toString()) na chave (ex.: "nome") definida
            editor.putString("nome", txtNome.text.toString())
            editor.putString("tratamento", listTratamento.selectedItem.toString())

            // aplicar modificações no shared preferences
            editor.apply()

            // toast para notificar sucesso no salvamento
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })

        btnExibir.setOnClickListener(View.OnClickListener {

            // instanciar a activity para fazer navegação para ela
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }
}