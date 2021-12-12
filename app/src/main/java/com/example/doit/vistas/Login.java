package com.example.doit.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doit.R;
import com.example.doit.controladores.LoginControlador;
import com.example.doit.utiles.ValidarCorreo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private String correo="", password="";
    private Button b_ingresar;
    private TextView tv_registrate, tv_olvidocontraseña ;
    private Toolbar toolbar;
    private EditText tie_correo, tie_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioConectado();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b_ingresar = findViewById(R.id.b_ingresar);
        tie_correo = findViewById(R.id.tie_correo);
        tie_password = findViewById(R.id.tie_password);
        tv_registrate = findViewById(R.id.tv_registrate);
        tv_olvidocontraseña = findViewById(R.id.tv_olvidocontraseña);

        b_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                correo = tie_correo.getText().toString();
                password = tie_password.getText().toString();

                if (habilitar()){
                    LoginControlador.login(Login.this, getCorreo(), getPassword());
                }else{
                    Toast.makeText(Login.this, "Ingreso de datos no validos", Toast.LENGTH_SHORT).show();
                }



                Intent intent = new Intent(Login.this, Principal.class);
                startActivity(intent);

            }

        });

        tv_olvidocontraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, RecuperarContraActivity.class);
                startActivity(intent);

            }
        });

        tv_registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, Registro.class);
                startActivity(intent);

            }
        });
    }


    private boolean habilitar(){

        String correo= getCorreo().trim();
        String password= getPassword().trim();


        if(ValidarCorreo.validar(correo) && password.length()>5){
            return true;

        }else{
            return false;
        }
    }

    public String getCorreo() {
        return tie_correo.getText().toString();
    }

    public String getPassword() {
        return tie_password.getText().toString();
    }

    private void usuarioConectado() {

        FirebaseUser usuario= FirebaseAuth.getInstance().getCurrentUser();

        if (usuario==null){
            startActivity(new Intent(this, Principal.class));
            finish();
        }
    }
}