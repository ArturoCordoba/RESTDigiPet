package com.digipet.prototype.orm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
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
    private Collection<ReporteEntity> reportesByIdSolicitud;
    private ClienteEntity clienteByIdCliente;
    private MascotaEntity mascotaByIdMascota;
    private ServicioEntity servicioByIdServicio;
    private Collection<SolicitudXCuidadorEntity> solicitudXCuidadorsByIdSolicitud;
    private Collection<SolicitudXHotelEntity> solicitudXHotelsByIdSolicitud;

    @Id
    @Column(name = "Id_solicitud")
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Basic
    @Column(name = "Hora_inicio")
    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Basic
    @Column(name = "Hora_final")
    public Timestamp getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Timestamp horaFinal) {
        this.horaFinal = horaFinal;
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
    @Column(name = "Estado_solicitud")
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Basic
    @Column(name = "Precio_unitario")
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Basic
    @Column(name = "Id_cliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "Id_mascota")
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    @Basic
    @Column(name = "Id_servicio")
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

    @OneToMany(mappedBy = "solicitudByIdSolicitud")
    public Collection<ReporteEntity> getReportesByIdSolicitud() {
        return reportesByIdSolicitud;
    }

    public void setReportesByIdSolicitud(Collection<ReporteEntity> reportesByIdSolicitud) {
        this.reportesByIdSolicitud = reportesByIdSolicitud;
    }

    @ManyToOne
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_cliente", nullable = false)
    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }

    @ManyToOne
    @JoinColumn(name = "Id_mascota", referencedColumnName = "Id_mascota", nullable = false)
    public MascotaEntity getMascotaByIdMascota() {
        return mascotaByIdMascota;
    }

    public void setMascotaByIdMascota(MascotaEntity mascotaByIdMascota) {
        this.mascotaByIdMascota = mascotaByIdMascota;
    }

    @ManyToOne
    @JoinColumn(name = "Id_servicio", referencedColumnName = "Id_servicio", nullable = false)
    public ServicioEntity getServicioByIdServicio() {
        return servicioByIdServicio;
    }

    public void setServicioByIdServicio(ServicioEntity servicioByIdServicio) {
        this.servicioByIdServicio = servicioByIdServicio;
    }

    @OneToMany(mappedBy = "solicitudByIdSolicitud")
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
