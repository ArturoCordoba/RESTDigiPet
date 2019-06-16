package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOTO_X_REPORTE", schema = "digipet", catalog = "")
@IdClass(FotoXReporteEntityPK.class)
public class FotoXReporteEntity {
    private int idReporte;
    private int foto;
    private ReporteEntity reporteByIdReporte;

    @Id
    @Column(name = "Id_reporte")
    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    @Id
    @Column(name = "Foto")
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

    @ManyToOne
    @JoinColumn(name = "Id_reporte", referencedColumnName = "Id_reporte", nullable = false)
    public ReporteEntity getReporteByIdReporte() {
        return reporteByIdReporte;
    }

    public void setReporteByIdReporte(ReporteEntity reporteByIdReporte) {
        this.reporteByIdReporte = reporteByIdReporte;
    }
}
