package com.digipet.prototype.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProvinciaXCuidadorEntityPK implements Serializable {
    private int idCuidador;
    private int idProvincia;

    @Column(name = "Id_cuidador", nullable = false)
    @Id
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Column(name = "Id_provincia", nullable = false)
    @Id
    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinciaXCuidadorEntityPK that = (ProvinciaXCuidadorEntityPK) o;
        return idCuidador == that.idCuidador &&
                idProvincia == that.idProvincia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuidador, idProvincia);
    }
}
