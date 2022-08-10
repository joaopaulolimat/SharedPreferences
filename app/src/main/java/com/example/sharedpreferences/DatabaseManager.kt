package com.example.sharedpreferences

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String?) : SQLiteOpenHelper(context,name, null, 1 ) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20),\n" +
                "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                "\t);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL,\n" +
                "\tNOME VARCHAR(20),\n" +
                "\tTRATAMENTO VARCHAR(20),\n" +
                "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                "\t);")
    }

    fun insereSaudacao(id:Int, nome: String, tratamento: String){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put("ID_SAUDACAO", id)
        cv.put("NOME", nome)
        cv.put("TRATAMENTO", tratamento)
        db.insert("SAUDACAO", "ID_SAUDACAO", cv)
    }

    fun listaSaudacao(): Cursor {
        // abre o banco de dados e expõe métodos para gerenciar a leitura do banco de dados
        var db = this.readableDatabase

        // escrevendo um comando para o banco de dados que retorna nome e tratamento
        var cur = db.rawQuery("select NOME, TRATAMENTO from SAUDACAO", null)

        // retorna um cursor para manipular os resultados do select
        return cur
    }

    fun removeSaudacao(){
        // abre o banco de dados e expõe métodos para gerenciar a escrever no banco de dados
        var db = this.writableDatabase

        // deletando o primeiro registro do banco de dados
        db.delete("SAUDACAO", "ID_SAUDACAO=1", null)
    }
}