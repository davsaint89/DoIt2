package com.example.doit.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.doit.R;
import com.example.doit.controladores.LoginControlador;
import com.example.doit.controladores.RecuperarContraControlador;
import com.example.doit.utiles.ValidarCorreo;
import com.google.android.material.textfield.TextInputEditText;

public class RecuperarContraActivity extends AppCompatActivity {

    private TextInputEditText  tie_correo;
    private Button b_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);

        tie_correo=findViewById(R.id.tie_correo);
        b_enviar=findViewById(R.id.b_enviar);

        b_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (habilitar()){
                    RecuperarContraControlador.login(RecuperarContraActivity.this, getCorreo());
                }else{
                    Toast.makeText(RecuperarContraActivity.this, "Error al intentar recuperar contraseña", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean habilitar(){

        String correo= getCorreo().trim();


        if(ValidarCorreo.validar(correo)){
            return true;

        }else{
            return false;
        }
    }

    public String getCorreo() {
        return tie_correo.getText().toString();
    }
}