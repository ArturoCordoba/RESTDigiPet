package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PROVINCIA", schema = "digipet", catalog = "")
public class ProvinciaEntity {
    private int idProvincia;
    private String nombre;
    private Collection<ClienteEntity> clientesByIdProvincia;
    private Collection<ProvinciaXCuidadorEntity> provinciaXCuidadorsByIdProvincia;

    @Id
    @Column(name = "Id_provincia")
    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
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
        ProvinciaEntity that = (ProvinciaEntity) o;
        return idProvincia == that.idProvincia &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProvincia, nombre);
    }

    @OneToMany(mappedBy = "provinciaByIdProvincia")
    public Collection<ClienteEntity> getClientesByIdProvincia() {
        return clientesByIdProvincia;
    }

    public void setClientesByIdProvincia(Collection<ClienteEntity> clientesByIdProvincia) {
        this.clientesByIdProvincia = clientesByIdProvincia;
    }

    @OneToMany(mappedBy = "provinciaByIdProvincia")
    public Collection<ProvinciaXCuidadorEntity> getProvinciaXCuidadorsByIdProvincia() {
        return provinciaXCuidadorsByIdProvincia;
    }

    public void setProvinciaXCuidadorsByIdProvincia(Collection<ProvinciaXCuidadorEntity> provinciaXCuidadorsByIdProvincia) {
        this.provinciaXCuidadorsByIdProvincia = provinciaXCuidadorsByIdProvincia;
    }
}
