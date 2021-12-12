package com.example.doit.controladores;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.doit.vistas.Login;
import com.example.doit.vistas.MuroPerfiles;
import com.example.doit.vistas.Principal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginControlador {
    public static void login(Activity activity, String correo, String password) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(correo, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            activity.startActivity(new Intent(activity, Principal.class));
                            activity.finish();

                        }else{
                            Toast.makeText(activity, "Error al intentar iniciar sesion", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
