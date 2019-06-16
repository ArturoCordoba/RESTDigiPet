package com.digipet.prototype.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FotoXMascotaEntityPK implements Serializable {
    private int idMascota;
    private String foto;

    @Column(name = "Id_mascota", nullable = false)
    @Id
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    @Column(name = "Foto", nullable = false, length = 30)
    @Id
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
        FotoXMascotaEntityPK that = (FotoXMascotaEntityPK) o;
        return idMascota == that.idMascota &&
                Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMascota, foto);
    }
}
