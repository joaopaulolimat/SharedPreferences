package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // instancia o DatabaseManager
        val db = DatabaseManager(this, "SAUDACAO")

        // constante que arma
        val cursor = db.listaSaudacao()

        var nome= ""
        var tratamento = ""

        if(cursor.count >= 0){
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        if(tratamento.equals("Sem Tratamento")){
            // mostrar texto na label
            lbSaudacao.text = nome
        }
        else {
            lbSaudacao.text = tratamento +" "+nome
        }
    }
}