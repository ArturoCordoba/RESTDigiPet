package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOTO_X_REPORTE", schema = "digipet")
public class FotoXReporteEntity {
    private String foto;
    private ReporteEntity reporte;

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
        FotoXReporteEntity that = (FotoXReporteEntity) o;
        return Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foto);
    }

    @ManyToOne
    @JoinColumn(name = "Id_reporte", referencedColumnName = "Id_reporte", nullable = false)
    public ReporteEntity getReporte() {
        return reporte;
    }

    public void setReporte(ReporteEntity reporte) {
        this.reporte = reporte;
    }
}
