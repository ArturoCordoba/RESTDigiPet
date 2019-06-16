package com.digipet.prototype.orm;

import javax.persistence.*;

@Entity
@Table(name = "BADGE_X_CUIDADOR", schema = "digipet")
public class BadgeXCuidadorEntity {
    private CuidadorEntity cuidador;
    private BadgeEntity badge;

    @ManyToOne
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_cuidador", nullable = false)
    public CuidadorEntity getCuidador() {
        return cuidador;
    }

    public void setCuidador(CuidadorEntity cuidador) {
        this.cuidador = cuidador;
    }

    @ManyToOne
    @JoinColumn(name = "Id_badge", referencedColumnName = "Id_badge", nullable = false)
    public BadgeEntity getBadge() {
        return badge;
    }

    public void setBadge(BadgeEntity badge) {
        this.badge = badge;
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
