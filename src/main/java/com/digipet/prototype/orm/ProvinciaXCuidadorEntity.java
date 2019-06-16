package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROVINCIA_X_CUIDADOR", schema = "digipet", catalog = "")
@IdClass(ProvinciaXCuidadorEntityPK.class)
public class ProvinciaXCuidadorEntity {
    private int idCuidador;
    private int idProvincia;
    private CuidadorEntity cuidadorByIdCuidador;
    private ProvinciaEntity provinciaByIdProvincia;

    @Id
    @Column(name = "Id_cuidador")
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Id
    @Column(name = "Id_provincia")
    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinciaXCuidadorEntity that = (ProvinciaXCuidadorEntity) o;
        return idCuidador == that.idCuidador &&
                idProvincia == that.idProvincia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuidador, idProvincia);
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
    @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia", nullable = false)
    public ProvinciaEntity getProvinciaByIdProvincia() {
        return provinciaByIdProvincia;
    }

    public void setProvinciaByIdProvincia(ProvinciaEntity provinciaByIdProvincia) {
        this.provinciaByIdProvincia = provinciaByIdProvincia;
    }
}
