package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
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

    @Id
    @Column(name = "Id_cuidador", nullable = false)
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Basic
    @Column(name = "Carne", nullable = false, length = 10)
    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    @Basic
    @Column(name = "Telefono_movil", nullable = false, length = 10)
    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @Basic
    @Column(name = "Id_universidad", nullable = false)
    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    @Basic
    @Column(name = "Canton", nullable = false, length = 30)
    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @Basic
    @Column(name = "Opcion_provincias", nullable = false)
    public byte getOpcionProvincias() {
        return opcionProvincias;
    }

    public void setOpcionProvincias(byte opcionProvincias) {
        this.opcionProvincias = opcionProvincias;
    }

    @Basic
    @Column(name = "Email_2", nullable = true, length = 30)
    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    @Basic
    @Column(name = "Descripcion", nullable = false, length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Fecha_Inscripcion", nullable = false)
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
}
