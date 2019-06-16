package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TAMANO", schema = "digipet", catalog = "")
public class TamanoEntity {
    private int idTamano;
    private String nombre;
    private Collection<MascotaEntity> mascotasByIdTamano;

    @Id
    @Column(name = "Id_tamano")
    public int getIdTamano() {
        return idTamano;
    }

    public void setIdTamano(int idTamano) {
        this.idTamano = idTamano;
    }

    @Basic
    @Column(name = "Nombre")
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
        TamanoEntity that = (TamanoEntity) o;
        return idTamano == that.idTamano &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTamano, nombre);
    }

    @OneToMany(mappedBy = "tamanoByIdTamano")
    public Collection<MascotaEntity> getMascotasByIdTamano() {
        return mascotasByIdTamano;
    }

    public void setMascotasByIdTamano(Collection<MascotaEntity> mascotasByIdTamano) {
        this.mascotasByIdTamano = mascotasByIdTamano;
    }
}
