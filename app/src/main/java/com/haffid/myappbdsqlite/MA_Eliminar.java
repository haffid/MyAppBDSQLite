package com.haffid.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haffid.myappbdsqlite.complementos.ConectorSQLite;
import com.haffid.myappbdsqlite.complementos.ConstantesSQL;

public class MA_Eliminar extends AppCompatActivity {
    EditText editTextBuscarD;
    TextView textViewNombreD, textViewRazaD, textViewColorD, textViewEdadD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_eliminar);

        editTextBuscarD = findViewById(R.id.edtBuscarMascotaD);
        textViewNombreD = findViewById(R.id.txtNombreD);
        textViewRazaD = findViewById(R.id.txtRazaD);
        textViewColorD = findViewById(R.id.txtColorD);
        textViewEdadD = findViewById(R.id.txtEdadD);
    }

    public void delete(View view) {
        switch (view.getId()){
            case R.id.btnBuscarMascotaD:
                this.consultarID();
                break;
            case R.id.btnEliminarMascota:
                this.eliminarMascota();
                break;
        }
    }

    private void consultarID(){
        if(!editTextBuscarD.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getReadableDatabase();
            String[] parametro = {editTextBuscarD.getText().toString()};
            try {
                String consultarID;
                consultarID = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+", "+ConstantesSQL.CAMPO_RAZA+", "+
                        ConstantesSQL.CAMPO_COLOR+", "+ConstantesSQL.CAMPO_EDAD+" FROM "+ConstantesSQL.TABLA_MASCOTA+
                        " WHERE "+ConstantesSQL.CAMPO_ID+" = ?;";
                Cursor cursor = database.rawQuery(consultarID, parametro);
                cursor.moveToFirst();
                textViewNombreD.setText(cursor.getString(0));
                textViewRazaD.setText(cursor.getString(1));
                textViewColorD.setText(cursor.getString(2));
                textViewEdadD.setText(cursor.getString(3));
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

    private void eliminarMascota(){
        if(!editTextBuscarD.getText().toString().isEmpty()){
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaEliminar;
                consultaEliminar = "DELETE FROM "+ConstantesSQL.TABLA_MASCOTA+
                        " WHERE "+ConstantesSQL.CAMPO_ID+"= "+editTextBuscarD.getText().toString()+";";
                database.execSQL(consultaEliminar);
                database.close();

                editTextBuscarD.setText("");
                textViewNombreD.setText("");
                textViewRazaD.setText("");
                textViewColorD.setText("");
                textViewEdadD.setText("");
                Toast.makeText(this, "Datos Eliminados Correctamente", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.getMessage();
            }
        }else {
            Toast.makeText(this, "Debe de llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

}