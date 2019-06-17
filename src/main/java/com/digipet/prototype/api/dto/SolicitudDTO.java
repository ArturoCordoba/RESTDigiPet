package com.digipet.prototype.api.dto;

public class SolicitudDTO {
    private String horaInicio;
    private String horaFinal;
    private float duracion;
    private float precio;
    private int idMascota;
    private int idServicio;

    public SolicitudDTO() {

    }

    public SolicitudDTO(String horaInicio, String horaFinal, float duracion, float precio, int idMascota, int idServicio) {
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.duracion = duracion;
        this.precio = precio;
        this.idMascota = idMascota;
        this.idServicio = idServicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
}
