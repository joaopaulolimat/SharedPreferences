package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instancia a classe DatabaseManager
        val db = DatabaseManager(this, "SAUDACAO")


        // adicionar listener de click no botao
        btnSalvar.setOnClickListener(View.OnClickListener {

            // remove o primeiro registro de saudação
            db.removeSaudacao()

            // insere uma saudação de acordo com o input do app
            db.insereSaudacao(1, txtNome.text.toString(), listTratamento.selectedItem.toString())

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