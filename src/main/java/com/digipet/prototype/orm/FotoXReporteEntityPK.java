package com.digipet.prototype.orm;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FotoXReporteEntityPK implements Serializable {
    private int idReporte;
    private int foto;

    @Column(name = "Id_reporte", nullable = false)
    @Id
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    @Column(name = "Foto", nullable = false)
    @Id
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
        FotoXReporteEntityPK that = (FotoXReporteEntityPK) o;
        return idReporte == that.idReporte &&
                foto == that.foto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReporte, foto);
    }
}
