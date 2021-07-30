package com.haffid.myappbdsqlite.complementos;

public class ConstantesSQL {

    //Constantes para la utilizacion de las consultas SQL principales DDL

    // Base de datos
    public static final String BD_MASCOTA = "bd_mascota";

    //Tablas
    public static final String TABLA_MASCOTA = "tbl_mascota";

    //Campos de las tablas
    public static final String CAMPO_ID = "id_mascota";
    public static final String CAMPO_NOMBRE = "nombre_mascota";
    public static final String CAMPO_RAZA = "raza_mascota";
    public static final String CAMPO_COLOR = "color_mascota";
    public static final String CAMPO_EDAD = "edad_mascota";

    //Consultas con CREATE
    public static final String CREAR_TABLA_MASCOTA = "CREATE TABLE " + TABLA_MASCOTA +
            " (" + CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CAMPO_NOMBRE + " TEXT NOT NULL, " +
            CAMPO_RAZA + " TEXT NOT NULL," +
            CAMPO_COLOR + " TEXT NOT NULL, " +
            CAMPO_EDAD + " INTEGER NOT NULL);";

    //Consutas DROP
    public static final String BORRAR_TABLA = "DROP TABLE IF EXISTS " + TABLA_MASCOTA;

    //Version
    public static final int VERSION = 1;

}
