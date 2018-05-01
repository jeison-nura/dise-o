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
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class agregarEtiqueta extends AppCompatActivity {

    private ImageView botonAgregarR,botonRecuperarR,botonOlvidarR;
    private Button agregarEtiqueta;
    private Context context;
    private RecyclerView recyclerView;
    private TagAdapter adapter;
    private List<Tag> tagList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_etiqueta);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewTag);
        tagList = new ArrayList<>();
        adapter = new TagAdapter(this, tagList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareInfo();

        context = getApplicationContext();

        agregarEtiqueta = findViewById(R.id.add_eti);

        agregarEtiqueta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(agregarEtiqueta.this,añadirEtiqueta.class);
                startActivity(i);
            }
        });


        botonAgregarR = findViewById(R.id.botonAgregarRec);

        botonAgregarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(agregarEtiqueta.this, agregarRecordatorio.class);
                startActivity(i);
            }
        });

        botonRecuperarR = findViewById(R.id.botonRecuperarRec);

        botonRecuperarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(agregarEtiqueta.this, recuperarRecordatorio.class);
                startActivity(i);
            }
        });

        botonOlvidarR = findViewById(R.id.botonOlvidarRec);

        botonOlvidarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(agregarEtiqueta.this, olvidarRecordatorio.class);
                startActivity(i);
            }
        });
    }


    // Adding Some TrashInfo
    private void prepareInfo() {

        Tag tag = new Tag("Casa");
        tagList.add(tag);

        tag = new Tag("Oficina");
        tagList.add(tag);

        tag = new Tag("Trabajo");
        tagList.add(tag);

        tag = new Tag("Universidad");
        tagList.add(tag);

        adapter.notifyDataSetChanged();
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}
