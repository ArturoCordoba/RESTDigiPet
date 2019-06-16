package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UNIVERSIDAD", schema = "digipet")
public class UniversidadEntity {
    private int idUniversidad;
    private String nombre;

    @Id
    @Column(name = "Id_universidad", nullable = false)
    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversidadEntity that = (UniversidadEntity) o;
        return idUniversidad == that.idUniversidad &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUniversidad, nombre);
    }
}
