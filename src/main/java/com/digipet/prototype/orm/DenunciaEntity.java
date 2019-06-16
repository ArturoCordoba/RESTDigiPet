package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DENUNCIA", schema = "digipet")
public class DenunciaEntity {
    private int idDenuncia;
    private String descripcion;
    private ClienteEntity cliente;
    private CuidadorEntity cuidador;

    @Id
    @Column(name = "Id_denuncia")
    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
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
        DenunciaEntity that = (DenunciaEntity) o;
        return idDenuncia == that.idDenuncia &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDenuncia, descripcion);
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
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_cuidador", nullable = false)
    public CuidadorEntity getCuidador() {
        return cuidador;
    }

    public void setCuidador(CuidadorEntity cuidador) {
        this.cuidador = cuidador;
    }
}
