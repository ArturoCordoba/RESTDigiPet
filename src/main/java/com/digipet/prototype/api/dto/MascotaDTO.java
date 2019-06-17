package com.digipet.prototype.api.dto;

import java.util.List;

public class MascotaDTO {
    private int id_mascota;
    private String nombre;
    private String raza;
    private int edad;
    private String descripcion;
    private String fechaInscripcion;
    private String tamano;
    private List<String> listaFotos;
    private List<Integer> listaIdSolicitudes;

    public MascotaDTO() {

    }

    public MascotaDTO(int id_mascota, String nombre, String raza, int edad, String descripcion, String fechaInscripcion, String tamano,List<String> listaFotos, List<Integer> listaIdSolicitudes) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.descripcion = descripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.tamano = tamano;
        this.listaFotos = listaFotos;
        this.listaIdSolicitudes = listaIdSolicitudes;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public List<String> getListaFotos() {
        return listaFotos;
    }

    public void setListaFotos(List<String> listaFotos) {
        this.listaFotos = listaFotos;
    }

    public List<Integer> getListaIdSolicitudes() {
        return listaIdSolicitudes;
    }

    public void setListaIdSolicitudes(List<Integer> listaIdSolicitudes) {
        this.listaIdSolicitudes = listaIdSolicitudes;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
}
