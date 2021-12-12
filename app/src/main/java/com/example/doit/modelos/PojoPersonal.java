package com.example.doit.modelos;

public class PojoPersonal {
    
    private int foto;
    private String nombre;
    private float calificacion;

    public PojoPersonal() {
    }

    public PojoPersonal(int foto, String nombre, float calificacion) {
        this.foto = foto;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
