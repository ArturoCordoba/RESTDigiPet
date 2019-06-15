package com.digipet.prototype;

public class Estudiante {
    private String nombre;
    private int edad;
    private String graduado;

    public Estudiante(){}

    public Estudiante(String nombre, int edad, String graduado) {
        this.nombre = nombre;
        this.edad = edad;
        this.graduado = graduado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGraduado() {
        return graduado;
    }

    public void setGraduado(String graduado) {
        this.graduado = graduado;
    }
}
