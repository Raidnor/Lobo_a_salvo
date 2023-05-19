package com.example.lobo_a_salvo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLManager(context: Context): SQLiteOpenHelper(context,"usuarios.db",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE usuarios (correo VARCHAR(20) PRIMARY KEY, password VARCHAR(20) )");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addUsuario(context: Context,datos:Usuario):Boolean{
        //correo
        //password

        var response = true
        var contentValues = ContentValues()
        contentValues.put("correo",datos.correo)
        contentValues.put("password",datos.password)
        var db = SQLManager(context)
        var manager = db.writableDatabase
        try {
            manager.insert("usuarios",null,contentValues)
        }catch (e: Exception){
          print(e.message)
            response = false
        }
        finally {
            db.close()
        }
        return response

    }

}