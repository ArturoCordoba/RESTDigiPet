package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ESTADO", schema = "digipet", catalog = "")
public class EstadoEntity {
    private int idEstado;
    private String nombre;
    private Collection<UsuarioEntity> usuariosByIdEstado;

    @Id
    @Column(name = "Id_estado")
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
        EstadoEntity that = (EstadoEntity) o;
        return idEstado == that.idEstado &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, nombre);
    }

    @OneToMany(mappedBy = "estadoByIdEstado")
    public Collection<UsuarioEntity> getUsuariosByIdEstado() {
        return usuariosByIdEstado;
    }

    public void setUsuariosByIdEstado(Collection<UsuarioEntity> usuariosByIdEstado) {
        this.usuariosByIdEstado = usuariosByIdEstado;
    }
}
