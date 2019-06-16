package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUIDADOR", schema = "digipet")
public class CuidadorEntity {
    private int idCuidador;
    private String carne;
    private String telefonoMovil;
    private String canton;
    private byte opcionProvincias;
    private String email2;
    private String descripcion;
    private Date fechaInscripcion;
    private List<BadgeXCuidadorEntity> listaBadges;
    private UsuarioEntity usuario;
    private UniversidadEntity universidad;
    private List<DisponibilidadXCuidadorEntity> listaDisponibilidad;
    private List<ProvinciaXCuidadorEntity> listaProvincias;
    private List<SolicitudXCuidadorEntity> listaSolicitudes;

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
        return Objects.hash(idCuidador, carne, telefonoMovil, canton, opcionProvincias, email2, descripcion, fechaInscripcion);
    }

    @OneToMany(mappedBy = "cuidador")
    public List<BadgeXCuidadorEntity> getListaBadges() {
        return listaBadges;
    }

    public void setListaBadges(List<BadgeXCuidadorEntity> listaBadges) {
        this.listaBadges = listaBadges;
    }

    @OneToOne
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_usuario", nullable = false)
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "Id_universidad", referencedColumnName = "Id_universidad", nullable = false)
    public UniversidadEntity getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }

    @OneToMany(mappedBy = "cuidador")
    public List<DisponibilidadXCuidadorEntity> getListaDisponibilidad() {
        return listaDisponibilidad;
    }

    public void setListaDisponibilidad(List<DisponibilidadXCuidadorEntity> listaDisponibilidad) {
        this.listaDisponibilidad = listaDisponibilidad;
    }

    @OneToMany(mappedBy = "cuidador")
    public List<ProvinciaXCuidadorEntity> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(List<ProvinciaXCuidadorEntity> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    @OneToMany(mappedBy = "cuidador")
    public List<SolicitudXCuidadorEntity> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudXCuidadorEntity> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
}
