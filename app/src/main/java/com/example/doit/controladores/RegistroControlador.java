package com.example.doit.controladores;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.doit.vistas.Principal;
import com.example.doit.modelos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

public class RegistroControlador {

    public static void registro(Context contexto, String nombre, String correo, String password) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            guardarUsuario(contexto, nombre, correo);

                        }else{
                            Toast.makeText(contexto, "Error al intentar registrar usuario", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    private static void guardarUsuario(Context contexto, String nombre, String correo) {

        try{

            FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

            String id= firebaseUser.getUid();

            long tiempoRegistro= firebaseUser.getMetadata().getCreationTimestamp();

            Usuario usuario= new Usuario(id, correo, nombre, "", tiempoRegistro);
            FirebaseFirestore.getInstance()
                    .collection(ConstantesFirebase.USUARIOS)
                    .document(id)
                    .set(usuario, SetOptions.merge())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                Intent intent= new Intent(contexto, Principal.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                contexto.startActivity(intent);

                            }else{
                                Toast.makeText(contexto, "Error al intentar guardar datos del usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }catch (NullPointerException e){
            e.getCause();
        }
    }
}
