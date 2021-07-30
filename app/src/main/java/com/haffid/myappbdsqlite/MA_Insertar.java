package com.haffid.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.haffid.myappbdsqlite.complementos.ConectorSQLite;
import com.haffid.myappbdsqlite.complementos.ConstantesSQL;

import java.security.PrivateKey;

public class MA_Insertar extends AppCompatActivity {
    private EditText editTextNombre, editTextRaza, editTextColor, editTextEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_insertar);

        editTextNombre = findViewById(R.id.edtNombreMascota);
        editTextRaza = findViewById(R.id.edtRazaMascota);
        editTextColor= findViewById(R.id.edtColorMascota);
        editTextEdad = findViewById(R.id.edtEdadMascota);

    }

    public void click(View view) {
        this.insertarMascota();
    }

    private void insertarMascota(){
        if (!editTextNombre.getText().toString().isEmpty()&&
                !editTextRaza.getText().toString().isEmpty()&&
                !editTextColor.getText().toString().isEmpty()&&
                !editTextEdad.getText().toString().isEmpty()){

            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null,ConstantesSQL.VERSION);

            SQLiteDatabase database = conectorSQLite.getWritableDatabase();

            try{

                String consultaInsertar;
                consultaInsertar = "INSERT INTO "+ConstantesSQL.TABLA_MASCOTA + "("+ConstantesSQL.CAMPO_NOMBRE+","+
                        ConstantesSQL.CAMPO_RAZA + ", "+ConstantesSQL.CAMPO_COLOR+", "+ConstantesSQL.CAMPO_EDAD+
                        ") VALUES ('"+editTextNombre.getText().toString()+"','"+editTextRaza.getText().toString()+
                        "', '"+editTextColor.getText().toString()+"',"+editTextEdad.getText().toString()+");";

                database.execSQL(consultaInsertar);
                database.close();
                editTextNombre.setText("");
                editTextRaza.setText("");
                editTextColor.setText("");
                editTextEdad.setText("");

                Toast.makeText(this, "Datos Insertados Correctamente", Toast.LENGTH_SHORT).show();

            }catch  (Exception e){
                e.getMessage();
            }


        }else{
            Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
        }
    }
}