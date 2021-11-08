package com.example.menu.models;

import android.content.ContentValues;
import android.database.Cursor;

public class Posto extends Entidade {
    private long longitude;
    private long latitude;
    private String nome;
    private String endereco;

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public ContentValues getContentValues() {
        ContentValues contentValues=new ContentValues();
        contentValues.put("nome",getNome());
        return contentValues;
    }

    @Override
    public Entidade setContentValues(Cursor cursor) {
        Posto posto = new Posto();
        posto.setId(cursor.getInt(0));
        return posto;
    }

   /* @Override
    public String[] getCampos() {
        return new String[]{"id"};
    }*/

    @Override
    public String toString() {
        return "Posto{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
