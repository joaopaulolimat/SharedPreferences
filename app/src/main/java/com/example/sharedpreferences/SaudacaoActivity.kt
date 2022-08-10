package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // instancia um container para local storage chamado saudacao no modo privado
        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        // trazer valor da chave para uma constante, o segundo parâmetro é um valor default para evitar null pointer
        val nome = saudacaoPersistencia.getString("nome", "")
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        if(tratamento.equals("Sem Tratamento")){
            // mostrar texto na label
            lbSaudacao.text = nome
        }
        else {
            lbSaudacao.text = tratamento + " "+nome
        }
    }
}