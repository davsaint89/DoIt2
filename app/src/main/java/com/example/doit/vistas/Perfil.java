package com.example.doit.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.doit.R;
import com.google.android.material.textfield.TextInputEditText;

public class Perfil extends AppCompatActivity {

    String nombre="";
    TextInputEditText tie_nombre;
    Button b_regresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            nombre=bundle.getString("nombre");


        }

        tie_nombre=findViewById(R.id.tie_nombre);

        b_regresar=findViewById(R.id.b_regresar);

        tie_nombre.setText(nombre);

        b_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre=tie_nombre.getText().toString();


                Intent intent = new Intent(Perfil.this, Reservar.class);
                intent.putExtra("nombre", nombre);


                startActivity(intent);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide= new Slide(Gravity.BOTTOM);
            slide.setDuration(1000);
            getWindow().setEnterTransition(slide);

            getWindow().setReturnTransition(new Fade());
        }
    }

}