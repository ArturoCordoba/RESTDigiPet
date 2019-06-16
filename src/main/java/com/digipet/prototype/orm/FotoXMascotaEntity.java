package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOTO_X_MASCOTA", schema = "digipet", catalog = "")
@IdClass(FotoXMascotaEntityPK.class)
public class FotoXMascotaEntity {
    private int idMascota;
    private String foto;
    private MascotaEntity mascotaByIdMascota;

    @Id
    @Column(name = "Id_mascota")
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

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
        return idMascota == that.idMascota &&
                Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMascota, foto);
    }

    @ManyToOne
    @JoinColumn(name = "Id_mascota", referencedColumnName = "Id_mascota", nullable = false)
    public MascotaEntity getMascotaByIdMascota() {
        return mascotaByIdMascota;
    }

    public void setMascotaByIdMascota(MascotaEntity mascotaByIdMascota) {
        this.mascotaByIdMascota = mascotaByIdMascota;
    }
}
