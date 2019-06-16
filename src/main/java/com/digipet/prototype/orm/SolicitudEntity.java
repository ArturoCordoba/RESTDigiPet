package com.digipet.prototype.orm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SOLICITUD", schema = "digipet", catalog = "")
public class SolicitudEntity {
    private int idSolicitud;
    private Timestamp horaInicio;
    private Timestamp horaFinal;
    private int duracion;
    private String estadoSolicitud;
    private BigDecimal precioUnitario;
    private int idCliente;
    private int idMascota;
    private int idServicio;

    @Id
    @Column(name = "Id_solicitud", nullable = false)
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Basic
    @Column(name = "Hora_inicio", nullable = false)
    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Basic
    @Column(name = "Hora_final", nullable = false)
    public Timestamp getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Timestamp horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Basic
    @Column(name = "Duracion", nullable = false)
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "Estado_solicitud", nullable = false, length = 10)
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Basic
    @Column(name = "Precio_unitario", nullable = false, precision = 1)
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Basic
    @Column(name = "Id_cliente", nullable = false)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "Id_mascota", nullable = false)
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    @Basic
    @Column(name = "Id_servicio", nullable = false)
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudEntity that = (SolicitudEntity) o;
        return idSolicitud == that.idSolicitud &&
                duracion == that.duracion &&
                idCliente == that.idCliente &&
                idMascota == that.idMascota &&
                idServicio == that.idServicio &&
                Objects.equals(horaInicio, that.horaInicio) &&
                Objects.equals(horaFinal, that.horaFinal) &&
                Objects.equals(estadoSolicitud, that.estadoSolicitud) &&
                Objects.equals(precioUnitario, that.precioUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, horaInicio, horaFinal, duracion, estadoSolicitud, precioUnitario, idCliente, idMascota, idServicio);
    }
}
