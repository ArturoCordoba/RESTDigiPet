package com.digipet.prototype.api.dto;

public class SolicitudCuidadorDTO {
    private int idSolicitud;
    private String horaInicio;
    private String horaFinal;
    private int duracion;
    private String estadoSolicitud;
    private float precioUnitario;
    private int idReporte;
    private int idCliente;
    private int idMascota;
    private int idServicio;
    private int idCuidador;
    private float calificacion;
    private String metodoPago;
    private String direccion;
    private String descripcion;

    public SolicitudCuidadorDTO() {

    }

    public SolicitudCuidadorDTO(int idSolicitud, String horaInicio, String horaFinal, int duracion, String estadoSolicitud, float precioUnitario, int idReporte, int idCliente, int idMascota, int idServicio, int idCuidador, float calificacion, String metodoPago, String direccion, String descripcion) {
        this.idSolicitud = idSolicitud;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.duracion = duracion;
        this.estadoSolicitud = estadoSolicitud;
        this.precioUnitario = precioUnitario;
        this.idReporte = idReporte;
        this.idCliente = idCliente;
        this.idMascota = idMascota;
        this.idServicio = idServicio;
        this.idCuidador = idCuidador;
        this.calificacion = calificacion;
        this.metodoPago = metodoPago;
        this.direccion = direccion;
        this.descripcion = descripcion;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
