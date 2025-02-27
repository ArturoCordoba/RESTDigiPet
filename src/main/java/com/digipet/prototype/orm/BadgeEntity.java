package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "BADGE", schema = "digipet")
public class BadgeEntity {
    private int idBadge;
    private String nombre;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "Id_badge", nullable = false)
    public int getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(int idBadge) {
        this.idBadge = idBadge;
    }

    @Basic
    @Column(name = "Nombre", nullable = false, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadgeEntity that = (BadgeEntity) o;
        return idBadge == that.idBadge &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBadge, nombre);
    }
}
