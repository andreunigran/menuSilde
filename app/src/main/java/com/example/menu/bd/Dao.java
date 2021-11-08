package com.example.menu.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.menu.models.Entidade;

import java.util.LinkedList;
import java.util.List;

public class Dao {
    private final Context context;

    public Dao(Context context) {
        this.context = context;
    }
    public Long insere(Entidade entidade) {
        String nomeClass=entidade.getClass().getSimpleName();
        CriarBD criaBD = new CriarBD(context);
        SQLiteDatabase database = criaBD.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.putAll(entidade.getContentValues());

        return entidade.getId()!=null&&entidade.getId()>0?
                database.update(nomeClass,contentValues, "id=?", new String[]{entidade.getId()+""})
                :
                database.insertOrThrow(nomeClass, null, contentValues);
    }

    public List<Entidade> getDados(Class entidade, String campos[],String orderBy) throws InstantiationException, IllegalAccessException {
        Entidade entidadeTemp= (Entidade) entidade.newInstance();
        List<Entidade> retorno = new LinkedList<>();
        CriarBD criaBD = new CriarBD(context);
        SQLiteDatabase database = criaBD.getReadableDatabase();
        Cursor cursor = database.query(entidade.getSimpleName(), entidadeTemp.getCampos(),
                null, null,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                retorno.add(entidadeTemp.setContentValues(cursor));
            } while (cursor.moveToNext());
        }
        return retorno;
    }

    public Integer remover(Entidade entidade) {
        CriarBD criaBD = new CriarBD(context);
        SQLiteDatabase database = criaBD.getWritableDatabase();
        String[] argumentos = {entidade.getId() + ""};
        return database.delete(entidade.getClass().getSimpleName(),"id=?",
                argumentos );
    }

}
