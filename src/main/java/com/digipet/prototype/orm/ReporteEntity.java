package com.digipet.prototype.orm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "REPORTE", schema = "digipet", catalog = "")
public class ReporteEntity {
    private int idReporte;
    private int cantidadCaca;
    private int cantidadOrines;
    private int cantidadJuegos;
    private BigDecimal distancia;
    private String detalles;
    private int idSolicitud;
    private Collection<FotoXReporteEntity> fotoXReportesByIdReporte;
    private SolicitudEntity solicitudByIdSolicitud;

    @Id
    @Column(name = "Id_reporte")
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    @Basic
    @Column(name = "Cantidad_caca")
    public int getCantidadCaca() {
        return cantidadCaca;
    }

    public void setCantidadCaca(int cantidadCaca) {
        this.cantidadCaca = cantidadCaca;
    }

    @Basic
    @Column(name = "Cantidad_orines")
    public int getCantidadOrines() {
        return cantidadOrines;
    }

    public void setCantidadOrines(int cantidadOrines) {
        this.cantidadOrines = cantidadOrines;
    }

    @Basic
    @Column(name = "Cantidad_juegos")
    public int getCantidadJuegos() {
        return cantidadJuegos;
    }

    public void setCantidadJuegos(int cantidadJuegos) {
        this.cantidadJuegos = cantidadJuegos;
    }

    @Basic
    @Column(name = "Distancia")
    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    @Basic
    @Column(name = "Detalles")
    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Basic
    @Column(name = "Id_solicitud")
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReporteEntity that = (ReporteEntity) o;
        return idReporte == that.idReporte &&
                cantidadCaca == that.cantidadCaca &&
                cantidadOrines == that.cantidadOrines &&
                cantidadJuegos == that.cantidadJuegos &&
                idSolicitud == that.idSolicitud &&
                Objects.equals(distancia, that.distancia) &&
                Objects.equals(detalles, that.detalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReporte, cantidadCaca, cantidadOrines, cantidadJuegos, distancia, detalles, idSolicitud);
    }

    @OneToMany(mappedBy = "reporteByIdReporte")
    public Collection<FotoXReporteEntity> getFotoXReportesByIdReporte() {
        return fotoXReportesByIdReporte;
    }

    public void setFotoXReportesByIdReporte(Collection<FotoXReporteEntity> fotoXReportesByIdReporte) {
        this.fotoXReportesByIdReporte = fotoXReportesByIdReporte;
    }

    @ManyToOne
    @JoinColumn(name = "Id_solicitud", referencedColumnName = "Id_solicitud", nullable = false)
    public SolicitudEntity getSolicitudByIdSolicitud() {
        return solicitudByIdSolicitud;
    }

    public void setSolicitudByIdSolicitud(SolicitudEntity solicitudByIdSolicitud) {
        this.solicitudByIdSolicitud = solicitudByIdSolicitud;
    }
}
