package com.example.menu.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.StringTokenizer;

public class CriarBD extends SQLiteOpenHelper {

    public CriarBD(@Nullable Context context) {
        super(context, "BDCONTROLEABASTECIMENTO", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("DROP TABLE IF EXISTS VEICULO;DROP TABLE IF EXISTS POSTO;" +
                "create table VEICULO(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "descricao varchar(50),\n" +
                "placa varchar(10),\n" +
                "cor varchar(15),\n" +
                "kmAtual INTEGER\n" +
                ");");
        stringBuffer.append( "create table POSTO(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "nome varchar(50),\n" +
                "endereco varchar(10),\n" +
                "longitude INTEGER,\n" +
                "latitude INTEGER\n" +
                ");");
        StringTokenizer tokenizer = new StringTokenizer(stringBuffer.toString(), ";", false);

        while ( tokenizer.hasMoreTokens() )
        {
            db.execSQL(tokenizer.nextToken());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("DROP TABLE IF EXISTS VEICULO;DROP TABLE IF EXISTS POSTO;" +
                "create table VEICULO(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "descricao varchar(50),\n" +
                "placa varchar(10),\n" +
                "cor varchar(15),\n" +
                "kmAtual INTEGER\n" +
                ");");
        stringBuffer.append( "create table POSTO(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "nome varchar(50),\n" +
                "endereco varchar(10),\n" +
                "longitude INTEGER,\n" +
                "latitude INTEGER\n" +
                ");");
        StringTokenizer tokenizer = new StringTokenizer(stringBuffer.toString(), ";", false);

        while ( tokenizer.hasMoreTokens() )
        {
            db.execSQL(tokenizer.nextToken());
        }
    }
}
