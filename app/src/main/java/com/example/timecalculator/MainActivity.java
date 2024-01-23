package com.example.timecalculator;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTime1, editTextTime2;
    private Button btnSumar, btnRestar;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTime1 = findViewById(R.id.editTextTime1);
        editTextTime2 = findViewById(R.id.editTextTime2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        textViewResult = findViewById(R.id.textViewResult);
        Button btnLimpiar = findViewById(R.id.btnLimpiar);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarCampos();
            }
        });

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                sumarTiempos();
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restarTiempos();
            }
        });
    }

    private void sumarTiempos() {
        // Obtener tiempos ingresados
        String tiempo1 = editTextTime1.getText().toString();
        String tiempo2 = editTextTime2.getText().toString();

        // Implementar la lógica de suma aquí
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date1 = sdf.parse(tiempo1);
            Date date2 = sdf.parse(tiempo2);

            // Convertir las fechas a objetos Calendar para facilitar la manipulación
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.setTime(date1);
            calendar2.setTime(date2);

            // Sumar los tiempos
            calendar1.add(Calendar.HOUR, calendar2.get(Calendar.HOUR));
            calendar1.add(Calendar.MINUTE, calendar2.get(Calendar.MINUTE));
            calendar1.add(Calendar.SECOND, calendar2.get(Calendar.SECOND));

            // Obtener el tiempo resultante como Date
            Date resultadoDate = calendar1.getTime();
            String resultado = sdf.format(resultadoDate);

            // Actualizar el TextView con el resultado
            textViewResult.setText("Resultado de la suma: " + resultado);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private void restarTiempos() {
        // Obtener tiempos ingresados
        String tiempo1 = editTextTime1.getText().toString();
        String tiempo2 = editTextTime2.getText().toString();

        // Implementar la lógica de resta aquí
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date1 = sdf.parse(tiempo1);
            Date date2 = sdf.parse(tiempo2);

            // Convertir las fechas a objetos Calendar para facilitar la manipulación
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.setTime(date1);
            calendar2.setTime(date2);

            // Restar los tiempos
            calendar1.add(Calendar.HOUR, -calendar2.get(Calendar.HOUR));
            calendar1.add(Calendar.MINUTE, -calendar2.get(Calendar.MINUTE));
            calendar1.add(Calendar.SECOND, -calendar2.get(Calendar.SECOND));

            // Obtener el tiempo resultante como Date
            Date resultadoDate = calendar1.getTime();
            String resultado = sdf.format(resultadoDate);

            // Actualizar el TextView con el resultado
            textViewResult.setText("Resultado de la resta: " + resultado);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    private void limpiarCampos() {
        editTextTime1.setText("");
        editTextTime2.setText("");
        //textViewResult.setText("Resultado: 00:00:00");
    }
}

