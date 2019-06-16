package com.digipet.prototype.orm;

import javax.persistence.*;

@Entity
@Table(name = "SOLICITUD_X_HOTEL", schema = "digipet")
public class SolicitudXHotelEntity {
    private SolicitudEntity solicitudByIdSolicitud;
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name = "Id_solicitud", referencedColumnName = "Id_solicitud", nullable = false)
    public SolicitudEntity getSolicitudByIdSolicitud() {
        return solicitudByIdSolicitud;
    }

    public void setSolicitudByIdSolicitud(SolicitudEntity solicitudByIdSolicitud) {
        this.solicitudByIdSolicitud = solicitudByIdSolicitud;
    }

    @ManyToOne
    @JoinColumn(name = "Id_hotel", referencedColumnName = "Id_hotel", nullable = false)
    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    private int id;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
