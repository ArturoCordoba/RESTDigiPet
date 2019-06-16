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
    private SolicitudEntity solicitudByIdSolicitud;
    private CuidadorEntity cuidadorByIdCuidador;

    @Id
    @Column(name = "Id_solicitud")
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Id
    @Column(name = "Id_cuidador")
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Basic
    @Column(name = "Calificacion")
    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    @Basic
    @Column(name = "Metodo_pago")
    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Basic
    @Column(name = "Direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "Descripcion")
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

    @ManyToOne
    @JoinColumn(name = "Id_solicitud", referencedColumnName = "Id_solicitud", nullable = false)
    public SolicitudEntity getSolicitudByIdSolicitud() {
        return solicitudByIdSolicitud;
    }

    public void setSolicitudByIdSolicitud(SolicitudEntity solicitudByIdSolicitud) {
        this.solicitudByIdSolicitud = solicitudByIdSolicitud;
    }

    @ManyToOne
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_cuidador", nullable = false)
    public CuidadorEntity getCuidadorByIdCuidador() {
        return cuidadorByIdCuidador;
    }

    public void setCuidadorByIdCuidador(CuidadorEntity cuidadorByIdCuidador) {
        this.cuidadorByIdCuidador = cuidadorByIdCuidador;
    }
}
