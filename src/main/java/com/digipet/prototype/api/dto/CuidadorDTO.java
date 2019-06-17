package com.digipet.prototype.api.dto;

import java.util.List;

public class CuidadorDTO {
    private int idUsuario;
    private String primerNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email1;
    private String contraseña;
    private String fotoPerfil;
    private String provinciaResidencia;
    private int idRol;
    private int idEstado;
    private String carne;
    private String telefonoMovil;
    private String canton;
    private boolean opcionProvincias;
    private String email2;
    private String descripcion;
    private String fechaInscripcion;
    private String nombreUniversidad;
    private List<String> listaDisponibilidad;
    private List<String> listaProvincias;
    private List<String> listaIdSolcitudes;

    public CuidadorDTO() {

    }

    public CuidadorDTO(int idUsuario, String primerNombre, String primerApellido, String segundoApellido,
                       String email1, String contraseña, String fotoPerfil, int idRol, int idEstado,
                       String carne, String telefonoMovil, String canton, boolean opcionProvincias, String email2,
                       String descripcion, String fechaInscripcion, String nombreUniversidad,
                       List<String> listaDisponibilidad, List<String> listaProvincias, List<String> listaIdSolcitudes,
                       String provinciaResidencia) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email1 = email1;
        this.contraseña = contraseña;
        this.fotoPerfil = fotoPerfil;
        this.idRol = idRol;
        this.idEstado = idEstado;
        this.carne = carne;
        this.telefonoMovil = telefonoMovil;
        this.canton = canton;
        this.opcionProvincias = opcionProvincias;
        this.email2 = email2;
        this.descripcion = descripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.nombreUniversidad = nombreUniversidad;
        this.listaDisponibilidad = listaDisponibilidad;
        this.listaProvincias = listaProvincias;
        this.listaIdSolcitudes = listaIdSolcitudes;
        this.provinciaResidencia = provinciaResidencia;
    }

    public String getProvinciaResidencia() {
        return provinciaResidencia;
    }

    public void setProvinciaResidencia(String provinciaResidencia) {
        this.provinciaResidencia = provinciaResidencia;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
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

    public boolean isOpcionProvincias() {
        return opcionProvincias;
    }

    public void setOpcionProvincias(boolean opcionProvincias) {
        this.opcionProvincias = opcionProvincias;
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

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public List<String> getListaDisponibilidad() {
        return listaDisponibilidad;
    }

    public void setListaDisponibilidad(List<String> listaDisponibilidad) {
        this.listaDisponibilidad = listaDisponibilidad;
    }

    public List<String> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(List<String> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    public List<String> getListaIdSolcitudes() {
        return listaIdSolcitudes;
    }

    public void setListaIdSolcitudes(List<String> listaIdSolcitudes) {
        this.listaIdSolcitudes = listaIdSolcitudes;
    }
}
