package com.haffid.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.haffid.myappbdsqlite.complementos.ConectorSQLite;
import com.haffid.myappbdsqlite.complementos.ConstantesSQL;
import com.haffid.myappbdsqlite.complementos.MascotaVO;

import java.util.ArrayList;

public class MA_Mostrar extends AppCompatActivity {

    private ListView listView;
    //Arreglos
    //Llenar la lista
    ArrayList<String> listaDatos;
    //Obtener los datos de la base de datos
    ArrayList<MascotaVO> listaMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_mostrar);

        listView = findViewById(R.id.listaMostrar);

        this.mostrarMascota();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladoInformacion(position);
            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
        listView.setAdapter(arrayAdapter);

    }

    private void mostrarMascota() {
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTA, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLite.getReadableDatabase();
        try {
            MascotaVO mascotaVO;
            listaMascota = new ArrayList<>();
            String consultaCompleta;
            consultaCompleta = "SELECT * FROM " + ConstantesSQL.TABLA_MASCOTA + ";";
            Cursor cursor = database.rawQuery(consultaCompleta, null);

            while (cursor.moveToNext()) {
                mascotaVO = new MascotaVO();
                mascotaVO.setIdMascota(cursor.getInt(0));
                mascotaVO.setNombreMascota(cursor.getString(1));
                mascotaVO.setRazaMascota(cursor.getString(2));
                mascotaVO.setColorMascota(cursor.getString(3));
                mascotaVO.setEdadMascota(cursor.getInt(4));
                listaMascota.add(mascotaVO);
            }
            listaDatos = new ArrayList<>();
            for (int i = 0; i < listaMascota.size(); i++) {
                listaDatos.add(listaMascota.get(i).getIdMascota() + ". " + listaMascota.get(i).getNombreMascota());
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void trasladoInformacion(int position) {
        String idM, nombreM, razaM, colorM, edadM;
        idM = String.valueOf(listaMascota.get(position).getIdMascota());
        nombreM = listaMascota.get(position).getNombreMascota();
        razaM = listaMascota.get(position).getRazaMascota();
        colorM = listaMascota.get(position).getColorMascota();
        edadM = String.valueOf(listaMascota.get(position).getEdadMascota());

        Intent intent = new Intent(getApplicationContext(), MA_Detalle.class);
        intent.putExtra("id", idM);
        intent.putExtra("nombre", nombreM);
        intent.putExtra("raza", razaM);
        intent.putExtra("color", colorM);
        intent.putExtra("edad", edadM);
        startActivity(intent);


    }
}