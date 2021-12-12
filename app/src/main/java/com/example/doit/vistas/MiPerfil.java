package com.example.doit.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.doit.R;
import com.google.android.material.textfield.TextInputEditText;

public class MiPerfil extends AppCompatActivity {

    private String nombre = "", tipo_documento = "", documento = "", correo = "", password = "", direccion = "", ciudad = "", telefono = "";

    private TextInputEditText tie_nombre, tie_documento, tie_correo, tie_password, tie_direccion, tie_ciudad, tie_telefono;
    private Button b_guardar;
    private AutoCompleteTextView tie_tipdoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

        tie_tipdoc = findViewById(R.id.tie_tipdoc);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tdoc);
        tie_tipdoc.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nombre = bundle.getString("nombre");
            tipo_documento = bundle.getString("tipo_documento");
            documento = bundle.getString("documento");
            correo = bundle.getString("correo");
            password = bundle.getString("password");
            direccion = bundle.getString("direccion");
            ciudad = bundle.getString("ciudad");
            telefono = bundle.getString("telefono");
        }

        tie_nombre = findViewById(R.id.tie_nombre);
        tie_tipdoc = findViewById(R.id.tie_tipdoc);
        tie_documento = findViewById(R.id.tie_documento);
        tie_correo = findViewById(R.id.tie_correo);
        tie_password = findViewById(R.id.tie_password);
        tie_direccion = findViewById(R.id.tie_direccion);
        tie_ciudad = findViewById(R.id.tie_ciudad);
        tie_telefono = findViewById(R.id.tie_telefono);

        b_guardar = findViewById(R.id.b_guardar);

        tie_nombre.setText(nombre);
        tie_tipdoc.setText(tipo_documento);
        tie_documento.setText(documento);
        tie_correo.setText(correo);
        tie_password.setText(password);
        tie_direccion.setText(direccion);
        tie_ciudad.setText(ciudad);
        tie_telefono.setText(telefono);


        b_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre = tie_nombre.getText().toString();
                tipo_documento = tie_tipdoc.getText().toString();
                documento = tie_documento.getText().toString();
                correo = tie_correo.getText().toString();
                password = tie_password.getText().toString();
                direccion = tie_direccion.getText().toString();
                ciudad = tie_ciudad.getText().toString();
                telefono = tie_telefono.getText().toString();

                Intent intent = new Intent(MiPerfil.this, Perfil.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("tipo_documento", tipo_documento);
                intent.putExtra("documento", documento);
                intent.putExtra("correo", correo);
                intent.putExtra("password", password);
                intent.putExtra("direccion", direccion);
                intent.putExtra("ciudad", ciudad);
                intent.putExtra("telefono", telefono);

                startActivity(intent);
            }

        });
    }
    private static final String[] tdoc = new String[]{"CC", "CE", "PASSPORT"};
}


