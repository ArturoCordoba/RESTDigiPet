package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DISPONIBILIDAD_X_CUIDADOR", schema = "digipet")
public class DisponibilidadXCuidadorEntity {
    private int idDisponibilidad;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFinal;
    private CuidadorEntity cuidador;

    @Id
    @Column(name = "Id_disponibilidad")
    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    @Basic
    @Column(name = "Fecha_hora_inicio")
    public Timestamp getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    @Basic
    @Column(name = "Fecha_hora_final")
    public Timestamp getFechaHoraFinal() {
        return fechaHoraFinal;
    }

    public void setFechaHoraFinal(Timestamp fechaHoraFinal) {
        this.fechaHoraFinal = fechaHoraFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisponibilidadXCuidadorEntity that = (DisponibilidadXCuidadorEntity) o;
        return idDisponibilidad == that.idDisponibilidad &&
                Objects.equals(fechaHoraInicio, that.fechaHoraInicio) &&
                Objects.equals(fechaHoraFinal, that.fechaHoraFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisponibilidad, fechaHoraInicio, fechaHoraFinal);
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
