package com.example.doit.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.doit.R;
import com.google.android.material.textfield.TextInputEditText;

public class Perfiles extends AppCompatActivity {

    SwipeRefreshLayout srl_personal;
    ListView lv_personal;
    String[] personal;
    String nombre="",tipo_documento="", documento="", correo="", password="", direccion="", ciudad="", telefono="";
    TextInputEditText tie_nombre, tie_documento, tie_correo, tie_password, tie_direccion, tie_ciudad, tie_telefono;
    AutoCompleteTextView tie_tipdoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfiles);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            nombre=bundle.getString("nombre");
            tipo_documento = bundle.getString("tipo_documento");
            documento=bundle.getString("documento");
            correo=bundle.getString("correo");
            password=bundle.getString("password");
            direccion=bundle.getString("direccion");
            ciudad=bundle.getString("ciudad");
            telefono=bundle.getString("telefono");

        }

        srl_personal= findViewById(R.id.srl_personal);
        lv_personal= findViewById(R.id.lv_personal);

        personal = getResources().getStringArray(R.array.personal);
        lv_personal.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personal));
        lv_personal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(Perfiles.this, Perfil.class);
                intent.putExtra("nombre", personal[position]);


                startActivity(intent);
            }
        });
        srl_personal.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescarLista();
            }
        });

    }

    private void refrescarLista() {
        personal = getResources().getStringArray(R.array.personal);
        lv_personal.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personal));
        srl_personal.setRefreshing(false);
    }

}