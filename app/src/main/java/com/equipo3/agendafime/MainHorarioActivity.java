package com.equipo3.agendafime;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainHorarioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhorario);

        TextView Agregar;
        TextView Eliminar;
        TextView Menu;

        Agregar =findViewById(R.id.btnirAgregar);
        Eliminar =findViewById(R.id.btnireliminar);
        Menu =findViewById(R.id.btnirMenu);

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainHorarioActivity.this,AgregarHorarioActivity.class));
            }
        });

        Eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                startActivity(intent);
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainHorarioActivity.this,MenuActivity.class));
            }
        });


    }
}
