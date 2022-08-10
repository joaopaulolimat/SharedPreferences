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

        // adicionar listener de click no botao
        btnSalvar.setOnClickListener(View.OnClickListener {

            // concatenar valores para guardar no file stream
            val data = txtNome.text.toString() + ":" + listTratamento.selectedItem.toString()

            //chama método gravaDadoArquivo
            gravaDadoArquivo("saudacao", data)

            // toast para notificar sucesso no salvamento
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
        })

        btnExibir.setOnClickListener(View.OnClickListener {

            // instanciar a activity para fazer navegação para ela
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })


    }

    fun gravaDadoArquivo(fileName: String, data: String) {
        try{
            // openFileOutput método para guardar informações locais num arquivo dentro do contexto da aplicação
            val fs = openFileOutput(fileName, Context.MODE_PRIVATE)
            // escrever no arquivo os dados convertidos para um array de bytes
            fs.write(data.toByteArray())
            // fecha os streams e libera os recursos para escrever arquivos
            fs.close()
        }
        catch (e: FileNotFoundException) { Log.i("gravaDadoArquivo", "FileNotFoundException")}
        catch (e: IOException) { Log.i("gravaDadoArquivo", "IOException")}
    }
}