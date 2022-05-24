package com.equipo3.agendafime;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainAgendaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainagenda);

        TextView AgregarAgenda;

        TextView Menu;

        AgregarAgenda =findViewById(R.id.btnirAgregarAgenda);

        Menu =findViewById(R.id.btnirMenu);

        AgregarAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainAgendaActivity.this,AgregarAgendaActivity.class));
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainAgendaActivity.this,MenuActivity.class));
            }
        });
    }
}
