package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "HOTEL", schema = "digipet")
public class HotelEntity {
    private int idHotel;
    private String nombre;
    private String direccion;
    private int capacidad;
    private String descripcion;
    private List<SolicitudXHotelEntity> listaSolicutdes;

    @Id
    @Column(name = "Id_hotel")
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
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
    @Column(name = "Direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "Capacidad")
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Basic
    @Column(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelEntity that = (HotelEntity) o;
        return idHotel == that.idHotel &&
                capacidad == that.capacidad &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, nombre, direccion, capacidad, descripcion);
    }

    @OneToMany(mappedBy = "hotel")
    public List<SolicitudXHotelEntity> getListaSolicutdes() {
        return listaSolicutdes;
    }

    public void setListaSolicutdes(List<SolicitudXHotelEntity> listaSolicutdes) {
        this.listaSolicutdes = listaSolicutdes;
    }
}
