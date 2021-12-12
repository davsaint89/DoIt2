package com.example.doit.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.doit.R;
import com.example.doit.controladores.RegistroControlador;
import com.example.doit.utiles.ValidarCorreo;
import com.google.android.material.textfield.TextInputEditText;

public class Registro extends AppCompatActivity {

    private String nombre="", correo="", password="", confirmar_contraseña="";

    private TextInputEditText tie_nombre, tie_correo, tie_password, tie_confirmarContra;
    private Button b_continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        tie_nombre=findViewById(R.id.tie_nombre);
        tie_correo=findViewById(R.id.tie_correo);
        tie_password=findViewById(R.id.tie_password);
        tie_confirmarContra= findViewById(R.id.tie_confirmarContra);

        b_continuar=findViewById(R.id.b_continuar);

        tie_nombre.setText(nombre);
        tie_correo.setText(correo);
        tie_password.setText(password);
        tie_confirmarContra.setText(confirmar_contraseña);

        b_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(Registro.this, MiPerfil.class);
                //startActivity(intent);

                if (habilitar()){
                    RegistroControlador.registro(Registro.this, getNombre(), getCorreo(), getPassword());
                }else{
                    Toast.makeText(Registro.this, "Ingreso de datos no validos", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private boolean habilitar(){

        String nombre= getNombre().trim();
        String correo= getCorreo().trim();
        String password= getPassword().trim();
        String confirmar_contraseña= getConfirmarContra().trim();


        if(nombre.length()>2 && ValidarCorreo.validar(correo) && password.length()>5 && confirmar_contraseña.equals(password)){
            return true;

        }else{
            return false;
        }
    }

    public String getNombre() {
        return tie_nombre.getText().toString();
    }

    public String getCorreo() {
        return tie_correo.getText().toString();
    }

    public String getPassword() {
        return tie_password.getText().toString();
    }

    public String getConfirmarContra() {
        return tie_confirmarContra.getText().toString();
    }


}