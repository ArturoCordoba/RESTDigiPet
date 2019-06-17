package com.digipet.prototype.api.dto;

import java.util.ArrayList;

public class ClientDTO {
    private int idUsuario;
    private String primerNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email1;
    private String contrasena;
    private String fotoPerfil;
    private int id_rol;
    private int id_estado;
    private int idCliente;
    private String telefonoMovil;
    private String canton;
    private String email2;
    private String descripcion;
    private String fechaInscripcion;
    private int id_provincia;
    private ArrayList<MascotaDTO> listaMascotas;
    private ArrayList<MetodoPagoDTO> listaPago;

    public ClientDTO() {

    }

    public ClientDTO(int idUsuario, String primerNombre, String primerApellido, String segundoApellido, String email1, String contrasena, String fotoPerfil, int id_rol, int id_estado, int idCliente, String telefonoMovil, String canton, String email2, String descripcion, String fechaInscripcion, int id_provincia, ArrayList<MascotaDTO> listaMascotas, ArrayList<MetodoPagoDTO> listaPago) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email1 = email1;
        this.contrasena = contrasena;
        this.fotoPerfil = fotoPerfil;
        this.id_rol = id_rol;
        this.id_estado = id_estado;
        this.telefonoMovil = telefonoMovil;
        this.canton = canton;
        this.email2 = email2;
        this.descripcion = descripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.id_provincia = id_provincia;
        this.listaMascotas = listaMascotas;
        this.listaPago = listaPago;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
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

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public ArrayList<MascotaDTO> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<MascotaDTO> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public ArrayList<MetodoPagoDTO> getListaPago() {
        return listaPago;
    }

    public void setListaPago(ArrayList<MetodoPagoDTO> listaPago) {
        this.listaPago = listaPago;
    }
}
