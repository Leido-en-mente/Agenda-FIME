package com.equipo3.agendafime;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class AgregarHorarioActivity extends AppCompatActivity {
    EditText txtDescripcion, txtInputHora, txtInputMinutos;
    Button Agregar;

    private static final int REQUEST_PERMISSION_ALARM = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarhorario);

        TextView Volver;
        Volver =findViewById(R.id.btnVolver);
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AgregarHorarioActivity.this,MainHorarioActivity.class));
            }
        });

        TextView Mostrar;
        Mostrar =findViewById(R.id.mostrar);
        Mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                startActivity(intent);
            }
        });

        txtDescripcion = findViewById(R.id.inputDescripcion);
        txtInputHora = (EditText) findViewById(R.id.inputHora);
        txtInputMinutos = (EditText) findViewById(R.id.inputMinutos);




        Agregar=findViewById(R.id.alarmId);
        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String Descipcion = txtDescripcion.getText().toString();
                    int hora = Integer.parseInt(txtInputHora.getText().toString());
                    int minuto = Integer.parseInt(txtInputMinutos.getText().toString());
                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_MESSAGE, Descipcion);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, hora);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, minuto);


                    if (hora <= 24 && minuto <= 59) {
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_LONG).show();
                    }
                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        /*Agregar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ObsoleteSdkInt")
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
                    establecerAlarma("Texto de la alarma", 9, 30);
                }else{
                    Log.i("TAG","API>=23");
                    if (ContextCompat.checkSelfPermission(AgregarHorarioActivity.this, Manifest.permission.SET_ALARM) == PackageManager.PERMISSION_GRANTED){
                        Log.i("TAG","Permission granted");
                        establecerAlarma("Texto de la alarma", 9, 30);
                    }else {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(AgregarHorarioActivity.this,Manifest.permission.SET_ALARM)){
                            Log.i("TAG","The user previamenente rechazo los permisos");
                        }else{
                            Log.i("TAG","Request Permision");
                        }
                        ActivityCompat.requestPermissions(AgregarHorarioActivity.this,new String[]{Manifest.permission.SET_ALARM},REQUEST_PERMISSION_ALARM);
                    }
                }
            }
        });*/
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_ALARM){
            if (permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                establecerAlarma("Texto de la alarma", 9, 30);
            }else{
                if(ActivityCompat.shouldShowRequestPermissionRationale(AgregarHorarioActivity.this,Manifest.permission.SET_ALARM)){
                    new AlertDialog.Builder(this).setMessage("Necesitas habilitar permisos para usar esta aplicacion")
                            .setPositiveButton("Volver a intentarlo", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ActivityCompat.requestPermissions(AgregarHorarioActivity.this,new String[]{Manifest.permission.SET_ALARM},REQUEST_PERMISSION_ALARM);
                                }
                            })
                            .setNegativeButton("No gracias", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //No hacer nada solo cerrar
                                }
                            }).show();
                }else{
                    Toast.makeText(this, "Necesitas activar los permisos de manera manual", Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }*/

    /*public void establecerAlarma(String mensaje, int hora, int minutos){
        Intent intent=new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, mensaje)
                .putExtra(AlarmClock.EXTRA_HOUR, hora)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutos);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }*/


}
