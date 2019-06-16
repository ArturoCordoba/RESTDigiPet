package com.digipet.prototype.orm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "SOLICITUD_X_CUIDADOR", schema = "digipet", catalog = "")
@IdClass(SolicitudXCuidadorEntityPK.class)
public class SolicitudXCuidadorEntity {
    private int idSolicitud;
    private int idCuidador;
    private BigDecimal calificacion;
    private String metodoPago;
    private String direccion;
    private String descripcion;

    @Id
    @Column(name = "Id_solicitud", nullable = false)
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Id
    @Column(name = "Id_cuidador", nullable = false)
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Basic
    @Column(name = "Calificacion", nullable = false, precision = 1)
    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    @Basic
    @Column(name = "Metodo_pago", nullable = false, length = 30)
    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Basic
    @Column(name = "Direccion", nullable = false, length = 300)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "Descripcion", nullable = false, length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudXCuidadorEntity that = (SolicitudXCuidadorEntity) o;
        return idSolicitud == that.idSolicitud &&
                idCuidador == that.idCuidador &&
                Objects.equals(calificacion, that.calificacion) &&
                Objects.equals(metodoPago, that.metodoPago) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, idCuidador, calificacion, metodoPago, direccion, descripcion);
    }
}
