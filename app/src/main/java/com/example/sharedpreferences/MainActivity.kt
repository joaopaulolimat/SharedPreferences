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

        btnSalvar.setOnClickListener(View.OnClickListener {
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", txtNome.text.toString())
            editor.putString("tratamento", listTratamento.selectedItem.toString())
            editor.apply()

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })

        btnExibir.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }
}