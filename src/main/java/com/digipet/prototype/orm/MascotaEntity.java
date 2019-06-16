package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MASCOTA", schema = "digipet")
public class MascotaEntity {
    private int idMascota;
    private String nombre;
    private String raza;
    private int edad;
    private String descripcion;
    private Date fechaInscripcion;
    private List<FotoXMascotaEntity> listaFotos;
    private ClienteEntity cliente;
    private TamanoEntity tamaño;
    private List<SolicitudEntity> listaSolicitudes;

    @Id
    @Column(name = "Id_mascota")
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
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
                edad == that.edad &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(raza, that.raza) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(fechaInscripcion, that.fechaInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMascota, nombre, raza, edad, descripcion, fechaInscripcion);
    }

    @OneToMany(mappedBy = "mascota")
    public List<FotoXMascotaEntity> getListaFotos() {
        return listaFotos;
    }

    public void setListaFotos(List<FotoXMascotaEntity> listaFotos) {
        this.listaFotos = listaFotos;
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
    @JoinColumn(name = "Id_tamano", referencedColumnName = "Id_tamano", nullable = false)
    public TamanoEntity getTamaño() {
        return tamaño;
    }

    public void setTamaño(TamanoEntity tamaño) {
        this.tamaño = tamaño;
    }

    @OneToMany(mappedBy = "mascota")
    public List<SolicitudEntity> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudEntity> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
}
