package com.equipo3.agendafime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;


import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

public class AgregarAgendaActivity extends AppCompatActivity implements View.OnClickListener{
    private int dia,mes,año, hora1, minuto1, dia2, mes2, año2, hora2, minuto2;

    CheckBox duracion;
    ButtonBarLayout agregar;
    EditText titulo;
    EditText descripcion;

    EditText taño;
    EditText thora;
    EditText taño2;
    EditText thora2;
    Button bfecha,bhora,bfecha2,bhora2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregaragenda);
        thora = (EditText) findViewById(R.id.edhora);
        taño = (EditText) findViewById(R.id.edfecha);
        thora2 = (EditText) findViewById(R.id.edhora2);
        taño2 = (EditText) findViewById(R.id.edfecha2);

        duracion = (CheckBox) findViewById(R.id.chkDuracion);

        titulo = (EditText) findViewById(R.id.etTitulo);
        descripcion = (EditText) findViewById(R.id.etDescripcion);

        bhora = (Button) findViewById(R.id.bhora);
        bhora2 = (Button) findViewById(R.id.bhora2);
        bfecha = (Button) findViewById(R.id.bfecha);
        bfecha2 = (Button) findViewById(R.id.bfecha2);

        bhora.setOnClickListener(this);
        bfecha.setOnClickListener(this);
        bhora2.setOnClickListener(this);
        bfecha2.setOnClickListener(this);

        TextView Volver;
        Volver =findViewById(R.id.btnVolver);
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AgregarAgendaActivity.this,MainAgendaActivity.class));
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v){
        if (v==bfecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            año=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    año=year;
                    dia=dayOfMonth;
                    mes=monthOfYear;
                    taño.setText("  "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia,mes,año);
            datePickerDialog.show();
        }
        if (v==bhora){
            final Calendar c= Calendar.getInstance();
            hora1=c.get(Calendar.HOUR_OF_DAY);
            minuto1=c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    minuto1=minute;
                    hora1=hourOfDay;
                    thora.setText("  "+hourOfDay+":"+minute);
                }
            },hora1,minuto1,false);
            timePickerDialog.show();
        }
        //////////////////////////////////////
        //////////////////////////////////////

        if (v==bfecha2){
            final Calendar c= Calendar.getInstance();
            dia2=c.get(Calendar.DAY_OF_MONTH);
            mes2=c.get(Calendar.MONTH);
            año2=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    año2=year;
                    dia2=dayOfMonth;
                    mes2=monthOfYear;
                    taño2.setText("  "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia2,mes2,año2);
            datePickerDialog.show();
        }
        if (v==bhora2){
            final Calendar c= Calendar.getInstance();
            hora2=c.get(Calendar.HOUR_OF_DAY);
            minuto2=c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    minuto2=minute;
                    hora2=hourOfDay;
                    thora2.setText("  "+hourOfDay+":"+minute);
                }
            },hora2,minuto2,false);
            timePickerDialog.show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Agregar(View v){
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        boolean val = false;
        Intent intent = null;
        while (val==false){

            try{
                cal.set(Calendar.YEAR, año);
                cal.set(Calendar.MONTH, mes);
                cal.set(Calendar.DAY_OF_MONTH, dia);

                cal.set(Calendar.HOUR_OF_DAY, hora1);
                cal.set(Calendar.MINUTE, minuto1);


                cal2.set(Calendar.YEAR, año2);
                cal2.set(Calendar.MONTH, mes2);
                cal2.set(Calendar.DAY_OF_MONTH, dia2);

                cal2.set(Calendar.HOUR_OF_DAY, hora2);
                cal2.set(Calendar.MINUTE, minuto2);

                intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");

                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal2.getTimeInMillis());

                intent.putExtra(CalendarContract.Events.ALL_DAY, duracion.isChecked());
                intent.putExtra(CalendarContract.Events.TITLE, titulo.getText().toString());
                intent.putExtra(CalendarContract.Events.DESCRIPTION, descripcion.getText().toString());

                startActivity(intent);
                val = true;
            } catch (Exception e) {

                taño.setText("");

                thora.setText("");

                Toast.makeText(getApplicationContext(), "Fecha Invalida", Toast.LENGTH_LONG).show();
            }
        }
    }
}
