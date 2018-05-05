package com.example.jeison.entrega2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class mapa extends AppCompatActivity{

    private ImageView botonAgregarR,botonRecuperarR,botonOlvidarR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_add);

        botonAgregarR = findViewById(R.id.botonAgregarRec);

        botonAgregarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mapa.this, agregarRecordatorio.class);
                startActivity(i);
            }
        });

        botonRecuperarR = findViewById(R.id.botonRecuperarRec);

        botonRecuperarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mapa.this, recuperarRecordatorio.class);
                startActivity(i);
            }
        });

        botonOlvidarR = findViewById(R.id.botonOlvidarRec);

        botonOlvidarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mapa.this, olvidarRecordatorio.class);
                startActivity(i);
            }
        });
    }
}
