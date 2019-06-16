package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BADGE_X_CUIDADOR", schema = "digipet", catalog = "")
@IdClass(BadgeXCuidadorEntityPK.class)
public class BadgeXCuidadorEntity {
    private int idCuidador;
    private int idBadge;
    private CuidadorEntity cuidadorByIdCuidador;
    private BadgeEntity badgeByIdBadge;

    @Id
    @Column(name = "Id_cuidador")
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Id
    @Column(name = "Id_badge")
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
        BadgeXCuidadorEntity that = (BadgeXCuidadorEntity) o;
        return idCuidador == that.idCuidador &&
                idBadge == that.idBadge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuidador, idBadge);
    }

    @ManyToOne
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_cuidador", nullable = false)
    public CuidadorEntity getCuidadorByIdCuidador() {
        return cuidadorByIdCuidador;
    }

    public void setCuidadorByIdCuidador(CuidadorEntity cuidadorByIdCuidador) {
        this.cuidadorByIdCuidador = cuidadorByIdCuidador;
    }

    @ManyToOne
    @JoinColumn(name = "Id_badge", referencedColumnName = "Id_badge", nullable = false)
    public BadgeEntity getBadgeByIdBadge() {
        return badgeByIdBadge;
    }

    public void setBadgeByIdBadge(BadgeEntity badgeByIdBadge) {
        this.badgeByIdBadge = badgeByIdBadge;
    }
}
