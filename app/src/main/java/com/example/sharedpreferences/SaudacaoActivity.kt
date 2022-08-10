package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        val nome = saudacaoPersistencia.getString("nome", "")
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        println("nome --> $nome")
        println("tratamento --> $tratamento")
        if(tratamento.equals("Sem Tratamento")){
            lbSaudacao.text = nome
        }
        else {
            lbSaudacao.text = tratamento + " "+nome
        }
    }
}