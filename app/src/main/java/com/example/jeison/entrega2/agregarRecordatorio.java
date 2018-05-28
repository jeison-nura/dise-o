package com.example.jeison.entrega2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class agregarRecordatorio extends AppCompatActivity {


    private ImageView agregMapa;
    private Button botonAgregarR;
    private TextView agregarEtiqueta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_recordatorio);

        agregMapa = findViewById(R.id.agregarMapa);

        agregMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(agregarRecordatorio.this,mapa.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


        agregarEtiqueta = findViewById(R.id.agregarEtiqueta);

        agregarEtiqueta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(agregarRecordatorio.this, agregarEtiqueta.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        botonAgregarR = findViewById(R.id.botonAgregarRec);

        botonAgregarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(agregarRecordatorio.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });



        //Primer Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<String> values = new ArrayList<String>();
        for (int i=1;i<=10;i++){
            values.add("Recordatorio " + i);
        }


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        //Segundo Spinner
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayList<String> values2 = new ArrayList<String>();
        for (int i=1;i<=10;i++){
            values2.add("Cra " + i + " # " + i+13);
        }

        spinner.setSelection(0);
        spinner2.setSelection(0);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
    }
}
