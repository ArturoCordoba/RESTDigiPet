package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOTO_X_MASCOTA", schema = "digipet", catalog = "")
@IdClass(FotoXMascotaEntityPK.class)
public class FotoXMascotaEntity {
    private int idMascota;
    private String foto;

    @Id
    @Column(name = "Id_mascota", nullable = false)
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    @Id
    @Column(name = "Foto", nullable = false, length = 30)
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
}
