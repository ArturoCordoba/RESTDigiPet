package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ROL", schema = "digipet", catalog = "")
public class RolEntity {
    private int idRol;
    private String nombre;
    private Collection<UsuarioEntity> usuariosByIdRol;

    @Id
    @Column(name = "Id_rol")
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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
        RolEntity rolEntity = (RolEntity) o;
        return idRol == rolEntity.idRol &&
                Objects.equals(nombre, rolEntity.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, nombre);
    }

    @OneToMany(mappedBy = "rolByIdRol")
    public Collection<UsuarioEntity> getUsuariosByIdRol() {
        return usuariosByIdRol;
    }

    public void setUsuariosByIdRol(Collection<UsuarioEntity> usuariosByIdRol) {
        this.usuariosByIdRol = usuariosByIdRol;
    }
}
