package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "REPORTE", schema = "digipet")
public class ReporteEntity {
    private int idReporte;
    private int duracion;
    private int cantidadCaca;
    private int cantidadOrines;
    private int cantidadJuegos;
    private int distancia;
    private String detalles;
    private List<FotoXReporteEntity> listaFotos;
    private SolicitudEntity solicitud;

    @Id
    @Column(name = "Id_reporte", nullable = false)
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    @Basic
    @Column(name = "Duracion")
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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
    @Column(name = "Cantidad_orines", nullable = false)
    public int getCantidadOrines() {
        return cantidadOrines;
    }

    public void setCantidadOrines(int cantidadOrines) {
        this.cantidadOrines = cantidadOrines;
    }

    @Basic
    @Column(name = "Cantidad_juegos", nullable = false)
    public int getCantidadJuegos() {
        return cantidadJuegos;
    }

    public void setCantidadJuegos(int cantidadJuegos) {
        this.cantidadJuegos = cantidadJuegos;
    }

    @Basic
    @Column(name = "Distancia")
    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Basic
    @Column(name = "Detalles", nullable = false, length = 300)
    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReporteEntity that = (ReporteEntity) o;
        return idReporte == that.idReporte &&
                duracion == that.duracion &&
                cantidadCaca == that.cantidadCaca &&
                cantidadOrines == that.cantidadOrines &&
                cantidadJuegos == that.cantidadJuegos &&
                distancia == that.distancia &&
                Objects.equals(detalles, that.detalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReporte, duracion, cantidadCaca, cantidadOrines, cantidadJuegos, distancia, detalles);
    }

    @OneToMany(mappedBy = "reporte")
    public List<FotoXReporteEntity> getListaFotos() {
        return listaFotos;
    }

    public void setListaFotos(List<FotoXReporteEntity> listaFotos) {
        this.listaFotos = listaFotos;
    }

    @ManyToOne
    @JoinColumn(name = "Id_solicitud", referencedColumnName = "Id_solicitud", nullable = false)
    public SolicitudEntity getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudEntity solicitud) {
        this.solicitud = solicitud;
    }
}
