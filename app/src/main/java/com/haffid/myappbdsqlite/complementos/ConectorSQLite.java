package com.haffid.myappbdsqlite.complementos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConectorSQLite extends SQLiteOpenHelper {
    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear tabla
        db.execSQL(ConstantesSQL.CREAR_TABLA_MASCOTA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Borrar la tabla si ya existe
        db.execSQL(ConstantesSQL.BORRAR_TABLA);
        onCreate(db);

    }
}
