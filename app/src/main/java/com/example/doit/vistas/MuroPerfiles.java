package com.example.doit.vistas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;


import com.example.doit.R;
import com.example.doit.adaptadores.AdaptadorMuroPerfiles;
import com.example.doit.modelos.PojoPersonal;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

public class MuroPerfiles extends AppCompatActivity {

    private RecyclerView rv_muro;
    private LinearLayoutManager linearLayoutManager;
    private AdaptadorMuroPerfiles adaptadorMuroPerfiles;
    private ArrayList<PojoPersonal> pojoPersonalArrayList;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muro_perfiles);

        /*toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/


        //control
        rv_muro = findViewById(R.id.rv_muro);

        linearLayoutManager = new LinearLayoutManager(this);

        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        //configurar
        rv_muro.setLayoutManager(linearLayoutManager);

        pojoPersonalArrayList = new ArrayList<PojoPersonal>();
        pojoPersonalArrayList.add(new PojoPersonal(R.drawable.clean1, "Maria", 4));
        pojoPersonalArrayList.add(new PojoPersonal(R.drawable.clean2, "Rosa", 3));
        pojoPersonalArrayList.add(new PojoPersonal(R.drawable.clean1, "Clara", 5));
        pojoPersonalArrayList.add(new PojoPersonal(R.drawable.clean2, "Patricia", 4));
        pojoPersonalArrayList.add(new PojoPersonal(R.drawable.clean1, "Sandra", 3));

        adaptadorMuroPerfiles = new AdaptadorMuroPerfiles(this, pojoPersonalArrayList);

        //configurar
        rv_muro.setAdapter(adaptadorMuroPerfiles);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.miPerfil:
                intent = new Intent(this, MiPerfil.class);
                startActivity(intent);

                return true;

            case R.id.notificacion:
                Toast.makeText(this, "Notificacion", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.mapa:
                intent = new Intent(this, Mapa.class);
                startActivity(intent);

                return true;

            case R.id.configuracion:
                intent = new Intent(this, Preferencias.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }

    }
}