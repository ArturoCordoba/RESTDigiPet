package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOTO_X_MASCOTA", schema = "digipet")
public class FotoXMascotaEntity {
    private String foto;
    private MascotaEntity mascota;

    @Id
    @Column(name = "Foto")
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoXMascotaEntity that = (FotoXMascotaEntity) o;
        return Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foto);
    }

    @ManyToOne
    @JoinColumn(name = "Id_mascota", referencedColumnName = "Id_mascota", nullable = false)
    public MascotaEntity getMascota() {
        return mascota;
    }

    public void setMascota(MascotaEntity mascota) {
        this.mascota = mascota;
    }
}
