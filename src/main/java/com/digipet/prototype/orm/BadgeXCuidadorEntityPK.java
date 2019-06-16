package com.digipet.prototype.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BadgeXCuidadorEntityPK implements Serializable {
    private int idCuidador;
    private int idBadge;

    @Column(name = "Id_cuidador")
    @Id
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Column(name = "Id_badge")
    @Id
    public int getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(int idBadge) {
        this.idBadge = idBadge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadgeXCuidadorEntityPK that = (BadgeXCuidadorEntityPK) o;
        return idCuidador == that.idCuidador &&
                idBadge == that.idBadge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuidador, idBadge);
    }
}
