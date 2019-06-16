package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DISPONIBILIDAD_X_CUIDADOR", schema = "digipet", catalog = "")
public class DisponibilidadXCuidadorEntity {
    private int idDisponibilidad;
    private int idCuidador;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFinal;
    private CuidadorEntity cuidadorByIdCuidador;

    @Id
    @Column(name = "Id_disponibilidad")
    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    @Basic
    @Column(name = "Id_cuidador")
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
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
                idCuidador == that.idCuidador &&
                Objects.equals(fechaHoraInicio, that.fechaHoraInicio) &&
                Objects.equals(fechaHoraFinal, that.fechaHoraFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisponibilidad, idCuidador, fechaHoraInicio, fechaHoraFinal);
    }

    @ManyToOne
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_cuidador", nullable = false)
    public CuidadorEntity getCuidadorByIdCuidador() {
        return cuidadorByIdCuidador;
    }

    public void setCuidadorByIdCuidador(CuidadorEntity cuidadorByIdCuidador) {
        this.cuidadorByIdCuidador = cuidadorByIdCuidador;
    }
}
