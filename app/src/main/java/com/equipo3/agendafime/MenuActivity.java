package com.equipo3.agendafime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView Agenda;
        TextView Horario;

        Agenda =findViewById(R.id.btnirAgenda);
        Horario =findViewById(R.id.btnirHorario);

        Agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,MainAgendaActivity.class));
            }
        });

        Horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,MainHorarioActivity.class));
            }
        });


    }
}
