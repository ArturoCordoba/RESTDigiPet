package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOTO_X_REPORTE", schema = "digipet", catalog = "")
@IdClass(FotoXReporteEntityPK.class)
public class FotoXReporteEntity {
    private int idReporte;
    private int foto;

    @Id
    @Column(name = "Id_reporte", nullable = false)
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    @Id
    @Column(name = "Foto", nullable = false)
    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoXReporteEntity that = (FotoXReporteEntity) o;
        return idReporte == that.idReporte &&
                foto == that.foto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReporte, foto);
    }
}
