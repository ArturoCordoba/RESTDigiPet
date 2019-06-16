package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SOLICITUD_X_HOTEL", schema = "digipet", catalog = "")
@IdClass(SolicitudXHotelEntityPK.class)
public class SolicitudXHotelEntity {
    private int idSolicitud;
    private int idHotel;

    @Id
    @Column(name = "Id_solicitud", nullable = false)
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Id
    @Column(name = "Id_hotel", nullable = false)
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
        SolicitudXHotelEntity that = (SolicitudXHotelEntity) o;
        return idSolicitud == that.idSolicitud &&
                idHotel == that.idHotel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSolicitud, idHotel);
    }
}
