package com.example.menu.models;

import android.content.ContentValues;
import android.database.Cursor;

public class Veiculo extends Entidade{
    private String descricao;
    private String placa;
    private String cor;
    private String kmAtual;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(String kmAtual) {
        this.kmAtual = kmAtual;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "descricao='" + descricao + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues contentValues=new ContentValues();
        contentValues.put("descricao",getDescricao());
        contentValues.put("id",getId());
        return contentValues;
    }

    @Override
    public Entidade setContentValues(Cursor cursor) {
        Veiculo v = new Veiculo();
        v.setId(cursor.getInt((int)cursor.getColumnIndex("id")));
        return v;
    }
}
