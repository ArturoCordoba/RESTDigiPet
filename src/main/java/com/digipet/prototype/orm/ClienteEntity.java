package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE", schema = "digipet", catalog = "")
public class ClienteEntity {
    private int idCliente;
    private String telefonoMovil;
    private int idProvincia;
    private String canton;
    private String email2;
    private String descripcion;
    private Date fechaInscripcion;
    private UsuarioEntity usuarioByIdCliente;
    private ProvinciaEntity provinciaByIdProvincia;
    private Collection<DenunciaEntity> denunciasByIdCliente;
    private Collection<MascotaEntity> mascotasByIdCliente;
    private Collection<PagoXClienteEntity> pagoXClientesByIdCliente;
    private Collection<SolicitudEntity> solicitudsByIdCliente;

    @Id
    @Column(name = "Id_cliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "Telefono_movil")
    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @Basic
    @Column(name = "Id_provincia")
    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Basic
    @Column(name = "Canton")
    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @Basic
    @Column(name = "Email_2")
    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    @Basic
    @Column(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Fecha_Inscripcion")
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return idCliente == that.idCliente &&
                idProvincia == that.idProvincia &&
                Objects.equals(telefonoMovil, that.telefonoMovil) &&
                Objects.equals(canton, that.canton) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(fechaInscripcion, that.fechaInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, telefonoMovil, idProvincia, canton, email2, descripcion, fechaInscripcion);
    }

    @OneToOne
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_usuario", nullable = false)
    public UsuarioEntity getUsuarioByIdCliente() {
        return usuarioByIdCliente;
    }

    public void setUsuarioByIdCliente(UsuarioEntity usuarioByIdCliente) {
        this.usuarioByIdCliente = usuarioByIdCliente;
    }

    @ManyToOne
    @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia", nullable = false)
    public ProvinciaEntity getProvinciaByIdProvincia() {
        return provinciaByIdProvincia;
    }

    public void setProvinciaByIdProvincia(ProvinciaEntity provinciaByIdProvincia) {
        this.provinciaByIdProvincia = provinciaByIdProvincia;
    }

    @OneToMany(mappedBy = "clienteByIdCliente")
    public Collection<DenunciaEntity> getDenunciasByIdCliente() {
        return denunciasByIdCliente;
    }

    public void setDenunciasByIdCliente(Collection<DenunciaEntity> denunciasByIdCliente) {
        this.denunciasByIdCliente = denunciasByIdCliente;
    }

    @OneToMany(mappedBy = "clienteByIdCliente")
    public Collection<MascotaEntity> getMascotasByIdCliente() {
        return mascotasByIdCliente;
    }

    public void setMascotasByIdCliente(Collection<MascotaEntity> mascotasByIdCliente) {
        this.mascotasByIdCliente = mascotasByIdCliente;
    }

    @OneToMany(mappedBy = "clienteByIdCliente")
    public Collection<PagoXClienteEntity> getPagoXClientesByIdCliente() {
        return pagoXClientesByIdCliente;
    }

    public void setPagoXClientesByIdCliente(Collection<PagoXClienteEntity> pagoXClientesByIdCliente) {
        this.pagoXClientesByIdCliente = pagoXClientesByIdCliente;
    }

    @OneToMany(mappedBy = "clienteByIdCliente")
    public Collection<SolicitudEntity> getSolicitudsByIdCliente() {
        return solicitudsByIdCliente;
    }

    public void setSolicitudsByIdCliente(Collection<SolicitudEntity> solicitudsByIdCliente) {
        this.solicitudsByIdCliente = solicitudsByIdCliente;
    }
}
