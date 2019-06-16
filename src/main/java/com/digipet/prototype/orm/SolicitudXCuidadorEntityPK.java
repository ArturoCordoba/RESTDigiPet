package com.digipet.prototype.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SolicitudXCuidadorEntityPK implements Serializable {
    private int idSolicitud;
    private int idCuidador;

    @Column(name = "Id_solicitud")
    @Id
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Column(name = "Id_cuidador")
    @Id
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudXCuidadorEntityPK that = (SolicitudXCuidadorEntityPK) o;
        return idSolicitud == that.idSolicitud &&
                idCuidador == that.idCuidador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, idCuidador);
    }
}
