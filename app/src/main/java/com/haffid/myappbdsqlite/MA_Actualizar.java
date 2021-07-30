package com.haffid.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.haffid.myappbdsqlite.complementos.ConectorSQLite;
import com.haffid.myappbdsqlite.complementos.ConstantesSQL;

public class MA_Actualizar extends AppCompatActivity {
    private EditText editTextBuscarU, editTextNombreU, editTextRazaU, editTextColorU, editTextEdadU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_actualizar);

        editTextBuscarU = findViewById(R.id.edtBuscarMascotaU);
        editTextNombreU = findViewById(R.id.edtNombreU);
        editTextRazaU = findViewById(R.id.edtRazaU);
        editTextColorU = findViewById(R.id.edtColorU);
        editTextEdadU = findViewById(R.id.edtEdadU);

    }

    public void update(View view) {
        switch (view.getId()) {
            case R.id.btnBuscarMascotaU:
                this.consultarID();
                break;
            case R.id.btnActulizarMascota:
                this.actualizarMascota();
                break;
        }
    }

    private void consultarID() {
        if(!editTextBuscarU.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getReadableDatabase();
            String[] parametro = {editTextBuscarU.getText().toString()};
            try {
                String consultarID;
                consultarID = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_RAZA+", "+
                        ConstantesSQL.CAMPO_COLOR+", "+ConstantesSQL.CAMPO_EDAD+" FROM "+ConstantesSQL.TABLA_MASCOTA+
                        " WHERE "+ConstantesSQL.CAMPO_ID+" = ?;";
                Cursor cursor = database.rawQuery(consultarID, parametro);
                cursor.moveToFirst();
                editTextNombreU.setText(cursor.getString(0));
                editTextRazaU.setText(cursor.getString(1));
                editTextColorU.setText(cursor.getString(2));
                editTextEdadU.setText(cursor.getString(3));
                cursor.close();
            }
            catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Debe ingresar el dato a buscar", Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizarMascota() {
        if(!editTextBuscarU.getText().toString().isEmpty() && !editTextNombreU.getText().toString().isEmpty()
                && !editTextRazaU.getText().toString().isEmpty() && !editTextColorU.getText().toString().isEmpty()
                && !editTextEdadU.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaActualizar;
                consultaActualizar = "UPDATE "+ConstantesSQL.TABLA_MASCOTA+" SET "+
                        ConstantesSQL.CAMPO_NOMBRE+"= '"+editTextNombreU.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_RAZA+"= '"+editTextRazaU.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_COLOR+"= '"+editTextColorU.getText().toString()+"', "+
                        ConstantesSQL.CAMPO_EDAD+"= "+editTextEdadU.getText().toString()+" WHERE "+
                        ConstantesSQL.CAMPO_ID+"= "+editTextBuscarU.getText().toString()+";";
                database.execSQL(consultaActualizar);
                database.close();

                editTextBuscarU.setText("");
                editTextNombreU.setText("");
                editTextRazaU.setText("");
                editTextColorU.setText("");
                editTextEdadU.setText("");
                Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.getMessage();
            }
        }
        else {
            Toast.makeText(this, "Debe de llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

}