package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MASCOTA", schema = "digipet", catalog = "")
public class MascotaEntity {
    private int idMascota;
    private int idCliente;
    private String nombre;
    private String raza;
    private int edad;
    private int idTamano;
    private String descripcion;
    private Date fechaInscripcion;
    private Collection<FotoXMascotaEntity> fotoXMascotasByIdMascota;
    private ClienteEntity clienteByIdCliente;
    private TamanoEntity tamanoByIdTamano;
    private Collection<SolicitudEntity> solicitudsByIdMascota;

    @Id
    @Column(name = "Id_mascota")
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
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
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Raza")
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Basic
    @Column(name = "Edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "Id_tamano")
    public int getIdTamano() {
        return idTamano;
    }

    public void setIdTamano(int idTamano) {
        this.idTamano = idTamano;
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
    @Column(name = "Fecha_inscripcion")
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
        MascotaEntity that = (MascotaEntity) o;
        return idMascota == that.idMascota &&
                idCliente == that.idCliente &&
                edad == that.edad &&
                idTamano == that.idTamano &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(raza, that.raza) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(fechaInscripcion, that.fechaInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMascota, idCliente, nombre, raza, edad, idTamano, descripcion, fechaInscripcion);
    }

    @OneToMany(mappedBy = "mascotaByIdMascota")
    public Collection<FotoXMascotaEntity> getFotoXMascotasByIdMascota() {
        return fotoXMascotasByIdMascota;
    }

    public void setFotoXMascotasByIdMascota(Collection<FotoXMascotaEntity> fotoXMascotasByIdMascota) {
        this.fotoXMascotasByIdMascota = fotoXMascotasByIdMascota;
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
    @JoinColumn(name = "Id_tamano", referencedColumnName = "Id_tamano", nullable = false)
    public TamanoEntity getTamanoByIdTamano() {
        return tamanoByIdTamano;
    }

    public void setTamanoByIdTamano(TamanoEntity tamanoByIdTamano) {
        this.tamanoByIdTamano = tamanoByIdTamano;
    }

    @OneToMany(mappedBy = "mascotaByIdMascota")
    public Collection<SolicitudEntity> getSolicitudsByIdMascota() {
        return solicitudsByIdMascota;
    }

    public void setSolicitudsByIdMascota(Collection<SolicitudEntity> solicitudsByIdMascota) {
        this.solicitudsByIdMascota = solicitudsByIdMascota;
    }
}
