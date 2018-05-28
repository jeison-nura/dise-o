package com.example.jeison.entrega2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class añadirEtiqueta extends AppCompatActivity {

    private ImageView botonAgregarR,botonRecuperarR,botonOlvidarR;
    private Button botonAgregarEtiqueta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aniadir_etiqueta);

        botonAgregarEtiqueta = findViewById(R.id.button2);

        botonAgregarEtiqueta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 =
                Toast.makeText(getApplicationContext(),"Etiqueta agregada",Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER,0,0);
                toast1.show();
                Intent i = new Intent(añadirEtiqueta.this, agregarEtiqueta.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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
