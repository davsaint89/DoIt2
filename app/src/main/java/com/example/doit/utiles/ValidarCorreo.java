package com.example.doit.utiles;

import android.util.Patterns;

import java.util.regex.Pattern;

public class ValidarCorreo {

    public static boolean validar(String correo){
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
}
