package com.example.jeison.entrega2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView botonAgregarR,botonRecuperarR,botonOlvidarR;
    private Context context;
    private RecyclerView recyclerView;
    private ReminderAdapter adapter;
    private List<Reminder> reminderList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        reminderList = new ArrayList<>();
        adapter = new ReminderAdapter(this, reminderList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareInfo();

        context = getApplicationContext();

        botonAgregarR = findViewById(R.id.botonAgregarRec);

        botonAgregarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, agregarRecordatorio.class);
                startActivity(i);
            }
        });

        botonRecuperarR = findViewById(R.id.botonRecuperarRec);

        botonRecuperarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, recuperarRecordatorio.class);
                startActivity(i);
            }
        });

        botonOlvidarR = findViewById(R.id.botonOlvidarRec);

        botonOlvidarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, olvidarRecordatorio.class);
                startActivity(i);
            }
        });



    }

    // Adding Some TrashInfo
    private void prepareInfo() {

        Reminder re = new Reminder("Recordarotio 1");
        reminderList.add(re);

        re = new Reminder("Recordarotio 2");
        reminderList.add(re);

        re = new Reminder("Recordarotio 3");
        reminderList.add(re);

        re = new Reminder("Recordarotio 4");
        reminderList.add(re);

        re = new Reminder("Recordarotio 5");
        reminderList.add(re);

        re = new Reminder("Recordarotio 6");
        reminderList.add(re);

        re = new Reminder("Recordarotio 7");
        reminderList.add(re);

        re = new Reminder("Recordarotio 8");
        reminderList.add(re);

        re = new Reminder("Recordarotio 9");
        reminderList.add(re);

        re = new Reminder("Recordarotio 10");
        reminderList.add(re);

        re = new Reminder("Recordarotio 11");
        reminderList.add(re);

        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem option_menu){
        int id=option_menu.getItemId();

        if (id==R.id.action_menu_1){
            Intent intent = new Intent(MainActivity.this, agregarEtiqueta.class);
            startActivity(intent);
        }
        if (id==R.id.action_menu_2){
            Intent intent = new Intent(MainActivity.this, mapa.class);
            startActivity(intent);
        }
        if (id==R.id.action_menu_3){
            Intent intent = new Intent(MainActivity.this, Settings_remty.class);
            startActivity(intent);
        }
        /*if (id==R.id.action_menu_4){
            Intent intent = new Intent(MainActivity.this, AboutUs.class);
            startActivity(intent);
        }*/
        if (id==R.id.action_menu_5){
            Intent intent = new Intent(MainActivity.this, developerListActivity.class);
            startActivity(intent);
        }
        return false;
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
