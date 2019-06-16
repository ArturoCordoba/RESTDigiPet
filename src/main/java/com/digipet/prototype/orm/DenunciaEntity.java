package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DENUNCIA", schema = "digipet", catalog = "")
public class DenunciaEntity {
    private int idDenuncia;
    private int idCliente;
    private int idCuidador;
    private String descripcion;

    @Id
    @Column(name = "Id_denuncia", nullable = false)
    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    @Basic
    @Column(name = "Id_cliente", nullable = false)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "Id_cuidador", nullable = false)
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Basic
    @Column(name = "Descripcion", nullable = false, length = 300)
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
        DenunciaEntity that = (DenunciaEntity) o;
        return idDenuncia == that.idDenuncia &&
                idCliente == that.idCliente &&
                idCuidador == that.idCuidador &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDenuncia, idCliente, idCuidador, descripcion);
    }
}
