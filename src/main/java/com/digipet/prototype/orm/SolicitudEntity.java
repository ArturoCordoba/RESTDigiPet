package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SOLICITUD", schema = "digipet")
public class SolicitudEntity {
    private int idSolicitud;
    private Timestamp horaInicio;
    private Timestamp horaFinal;
    private int duracion;
    private String estadoSolicitud;
    private int precioUnitario;
    private List<ReporteEntity> reporte;
    private ClienteEntity cliente;
    private MascotaEntity mascota;
    private ServicioEntity servicio;
    private Collection<SolicitudXCuidadorEntity> solicitudXCuidadorsByIdSolicitud;
    private Collection<SolicitudXHotelEntity> solicitudXHotelsByIdSolicitud;

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
    @Column(name = "Precio_unitario")
    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudEntity that = (SolicitudEntity) o;
        return idSolicitud == that.idSolicitud &&
                duracion == that.duracion &&
                precioUnitario == that.precioUnitario &&
                Objects.equals(horaInicio, that.horaInicio) &&
                Objects.equals(horaFinal, that.horaFinal) &&
                Objects.equals(estadoSolicitud, that.estadoSolicitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, horaInicio, horaFinal, duracion, estadoSolicitud, precioUnitario);
    }

    @OneToMany(mappedBy = "solicitud")
    public List<ReporteEntity> getReporte() {
        return reporte;
    }

    public void setReporte(List<ReporteEntity> reporte) {
        this.reporte = reporte;
    }

    @ManyToOne
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente", nullable = false)
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "Id_mascota", referencedColumnName = "Id_mascota", nullable = false)
    public MascotaEntity getMascota() {
        return mascota;
    }

    public void setMascota(MascotaEntity mascota) {
        this.mascota = mascota;
    }

    @ManyToOne
    @JoinColumn(name = "Id_servicio", referencedColumnName = "Id_servicio", nullable = false)
    public ServicioEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }

    @OneToMany(mappedBy = "solicitud")
    public Collection<SolicitudXCuidadorEntity> getSolicitudXCuidadorsByIdSolicitud() {
        return solicitudXCuidadorsByIdSolicitud;
    }

    public void setSolicitudXCuidadorsByIdSolicitud(Collection<SolicitudXCuidadorEntity> solicitudXCuidadorsByIdSolicitud) {
        this.solicitudXCuidadorsByIdSolicitud = solicitudXCuidadorsByIdSolicitud;
    }

    @OneToMany(mappedBy = "solicitudByIdSolicitud")
    public Collection<SolicitudXHotelEntity> getSolicitudXHotelsByIdSolicitud() {
        return solicitudXHotelsByIdSolicitud;
    }

    public void setSolicitudXHotelsByIdSolicitud(Collection<SolicitudXHotelEntity> solicitudXHotelsByIdSolicitud) {
        this.solicitudXHotelsByIdSolicitud = solicitudXHotelsByIdSolicitud;
    }
}
