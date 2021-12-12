package com.example.doit.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doit.R;

public class PreLogin extends AppCompatActivity {

    private Button btn_nuevo;
    private Button btn_miembro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_login);

        btn_nuevo=findViewById(R.id.btn_nuevo);
        btn_miembro=findViewById(R.id.btn_miembro);

        btn_nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreLogin.this, Registro.class);
                startActivity(intent);
            }
        });

        btn_miembro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreLogin.this, Login.class);
                startActivity(intent);

            }
        });
    }


}