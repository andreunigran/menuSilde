package com.example.menu.models;

import android.content.ContentValues;
import android.database.Cursor;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Entidade {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public abstract ContentValues getContentValues();
    public abstract Entidade setContentValues(Cursor cursor);
    public String[] getCampos() {
        String[] campos= new String[this.getClass().getDeclaredFields().length+1];
        int i=0;
        campos[i++]="id";
        for (Field campo : this.getClass().getDeclaredFields()) {
            campos[i++]=campo.getName();
        }
        return campos;
    }
}
