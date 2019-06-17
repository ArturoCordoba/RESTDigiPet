package com.digipet.prototype.api.dto;

import java.util.ArrayList;

public class MascotaDTO {
    private int id_mascota;
    private String nombre;
    private String raza;
    private int edad;
    private String descripcion;
    private String fechaInscripcion;
    private ArrayList<String> listaFotos;
    private ArrayList<SolicitudDTO> listaSolicitudes;
}
