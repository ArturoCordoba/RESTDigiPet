package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
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

    @Id
    @Column(name = "Id_cliente", nullable = false)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
    @Column(name = "Id_provincia", nullable = false)
    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
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
}
