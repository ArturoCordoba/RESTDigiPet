package com.digipet.prototype.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SolicitudXHotelEntityPK implements Serializable {
    private int idSolicitud;
    private int idHotel;

    @Column(name = "Id_solicitud", nullable = false)
    @Id
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Column(name = "Id_hotel", nullable = false)
    @Id
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudXHotelEntityPK that = (SolicitudXHotelEntityPK) o;
        return idSolicitud == that.idSolicitud &&
                idHotel == that.idHotel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, idHotel);
    }
}
