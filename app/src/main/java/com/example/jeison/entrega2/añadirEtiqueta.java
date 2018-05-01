package com.example.jeison.entrega2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class añadirEtiqueta extends AppCompatActivity {

    private ImageView botonAgregarR,botonRecuperarR,botonOlvidarR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aniadir_etiqueta);


        botonAgregarR = findViewById(R.id.botonAgregarRec);

        botonAgregarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(añadirEtiqueta.this, agregarRecordatorio.class);
                startActivity(i);
            }
        });

        botonRecuperarR = findViewById(R.id.botonRecuperarRec);

        botonRecuperarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(añadirEtiqueta.this, recuperarRecordatorio.class);
                startActivity(i);
            }
        });

        botonOlvidarR = findViewById(R.id.botonOlvidarRec);

        botonOlvidarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(añadirEtiqueta.this, olvidarRecordatorio.class);
                startActivity(i);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<String> values = new ArrayList<String>();
        for (int i=1;i<=10;i++){
            values.add("Color: " + i);
        }


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

}
