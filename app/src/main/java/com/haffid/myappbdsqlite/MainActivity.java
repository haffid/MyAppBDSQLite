package com.haffid.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsar(View view) {
        Intent intent;
        switch
        (view.getId()) {
            case R.id.btnInsertar:
                intent = new Intent(getApplicationContext(), MA_Insertar.class);
                startActivity(intent);
                break;
            case R.id.btnBuscar:
                intent = new Intent(getApplicationContext(), MA_Buscar.class);
                startActivity(intent);
                break;
            case R.id.btnMostrar:
                intent = new Intent(getApplicationContext(), MA_Mostrar.class);
                startActivity(intent);
                break;
            case R.id.btnActualizar:
                intent = new Intent(getApplicationContext(), MA_Actualizar.class);
                startActivity(intent);
                break;
            case R.id.btnEliminar:
                intent = new Intent(getApplicationContext(), MA_Eliminar.class);
                startActivity(intent);
                break;
        }

    }
}