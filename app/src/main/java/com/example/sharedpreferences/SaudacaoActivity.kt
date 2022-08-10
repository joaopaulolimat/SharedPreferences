package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // chama o método recuperaDadoArquivo
        val data = recuperaDadoArquivo("saudacao")

        // quebra a string através do delimitador definido, no caso é ":"
        val tokenizer = StringTokenizer(data, ":")

        // verifica se há tokens dentro do tokenizer, se sim retorna para constante
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem tratamento"

        if(tratamento.equals("Sem Tratamento")){
            // mostrar texto na label
            lbSaudacao.text = nome
        }
        else {
            lbSaudacao.text = tratamento + " "+nome
        }
    }
    fun recuperaDadoArquivo(fileName: String): String {
        return try{
            // abre o arquivo (fileName) criado no contexto da aplicação
            val fi = openFileInput(fileName)

            // le o arquivo recuperado acima e retorna seu valor para constante
            val data = fi.readBytes()

            // fecha o stream para liberar recursos
            fi.close()

            // conversão do conteúdo para string
            data.toString()

            // define os encorders de texto
            data.toString(Charset.defaultCharset())

        // catches para evitar crash do app, o primeiro para caso o
        // arquivo não seja encontrado e o segundo para problemas em abrir o arquivo
        } catch (e: FileNotFoundException) {
            ""
        } catch (e: IOException) {
            ""
        }
    }
}