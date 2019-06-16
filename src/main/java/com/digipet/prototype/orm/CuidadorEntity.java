package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CUIDADOR", schema = "digipet", catalog = "")
public class CuidadorEntity {
    private int idCuidador;
    private String carne;
    private String telefonoMovil;
    private int idUniversidad;
    private String canton;
    private byte opcionProvincias;
    private String email2;
    private String descripcion;
    private Date fechaInscripcion;
    private Collection<BadgeXCuidadorEntity> badgeXCuidadorsByIdCuidador;
    private UsuarioEntity usuarioByIdCuidador;
    private UniversidadEntity universidadByIdUniversidad;
    private Collection<DenunciaEntity> denunciasByIdCuidador;
    private Collection<DisponibilidadXCuidadorEntity> disponibilidadXCuidadorsByIdCuidador;
    private Collection<ProvinciaXCuidadorEntity> provinciaXCuidadorsByIdCuidador;
    private Collection<SolicitudXCuidadorEntity> solicitudXCuidadorsByIdCuidador;

    @Id
    @Column(name = "Id_cuidador")
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Basic
    @Column(name = "Carne")
    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
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
    @Column(name = "Id_universidad")
    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
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
    @Column(name = "Opcion_provincias")
    public byte getOpcionProvincias() {
        return opcionProvincias;
    }

    public void setOpcionProvincias(byte opcionProvincias) {
        this.opcionProvincias = opcionProvincias;
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
        CuidadorEntity that = (CuidadorEntity) o;
        return idCuidador == that.idCuidador &&
                idUniversidad == that.idUniversidad &&
                opcionProvincias == that.opcionProvincias &&
                Objects.equals(carne, that.carne) &&
                Objects.equals(telefonoMovil, that.telefonoMovil) &&
                Objects.equals(canton, that.canton) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(fechaInscripcion, that.fechaInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuidador, carne, telefonoMovil, idUniversidad, canton, opcionProvincias, email2, descripcion, fechaInscripcion);
    }

    @OneToMany(mappedBy = "cuidadorByIdCuidador")
    public Collection<BadgeXCuidadorEntity> getBadgeXCuidadorsByIdCuidador() {
        return badgeXCuidadorsByIdCuidador;
    }

    public void setBadgeXCuidadorsByIdCuidador(Collection<BadgeXCuidadorEntity> badgeXCuidadorsByIdCuidador) {
        this.badgeXCuidadorsByIdCuidador = badgeXCuidadorsByIdCuidador;
    }

    @OneToOne
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_usuario", nullable = false)
    public UsuarioEntity getUsuarioByIdCuidador() {
        return usuarioByIdCuidador;
    }

    public void setUsuarioByIdCuidador(UsuarioEntity usuarioByIdCuidador) {
        this.usuarioByIdCuidador = usuarioByIdCuidador;
    }

    @ManyToOne
    @JoinColumn(name = "Id_universidad", referencedColumnName = "Id_universidad", nullable = false)
    public UniversidadEntity getUniversidadByIdUniversidad() {
        return universidadByIdUniversidad;
    }

    public void setUniversidadByIdUniversidad(UniversidadEntity universidadByIdUniversidad) {
        this.universidadByIdUniversidad = universidadByIdUniversidad;
    }

    @OneToMany(mappedBy = "cuidadorByIdCuidador")
    public Collection<DenunciaEntity> getDenunciasByIdCuidador() {
        return denunciasByIdCuidador;
    }

    public void setDenunciasByIdCuidador(Collection<DenunciaEntity> denunciasByIdCuidador) {
        this.denunciasByIdCuidador = denunciasByIdCuidador;
    }

    @OneToMany(mappedBy = "cuidadorByIdCuidador")
    public Collection<DisponibilidadXCuidadorEntity> getDisponibilidadXCuidadorsByIdCuidador() {
        return disponibilidadXCuidadorsByIdCuidador;
    }

    public void setDisponibilidadXCuidadorsByIdCuidador(Collection<DisponibilidadXCuidadorEntity> disponibilidadXCuidadorsByIdCuidador) {
        this.disponibilidadXCuidadorsByIdCuidador = disponibilidadXCuidadorsByIdCuidador;
    }

    @OneToMany(mappedBy = "cuidadorByIdCuidador")
    public Collection<ProvinciaXCuidadorEntity> getProvinciaXCuidadorsByIdCuidador() {
        return provinciaXCuidadorsByIdCuidador;
    }

    public void setProvinciaXCuidadorsByIdCuidador(Collection<ProvinciaXCuidadorEntity> provinciaXCuidadorsByIdCuidador) {
        this.provinciaXCuidadorsByIdCuidador = provinciaXCuidadorsByIdCuidador;
    }

    @OneToMany(mappedBy = "cuidadorByIdCuidador")
    public Collection<SolicitudXCuidadorEntity> getSolicitudXCuidadorsByIdCuidador() {
        return solicitudXCuidadorsByIdCuidador;
    }

    public void setSolicitudXCuidadorsByIdCuidador(Collection<SolicitudXCuidadorEntity> solicitudXCuidadorsByIdCuidador) {
        this.solicitudXCuidadorsByIdCuidador = solicitudXCuidadorsByIdCuidador;
    }
}
