package com.digipet.prototype.orm;

import javax.persistence.*;

@Entity
@Table(name = "PROVINCIA_X_CUIDADOR", schema = "digipet")
public class ProvinciaXCuidadorEntity {
    private CuidadorEntity cuidador;
    private ProvinciaEntity provinciaByIdProvincia;

    @ManyToOne
    @JoinColumn(name = "Id_cuidador", referencedColumnName = "Id_cuidador", nullable = false)
    public CuidadorEntity getCuidador() {
        return cuidador;
    }

    public void setCuidador(CuidadorEntity cuidador) {
        this.cuidador = cuidador;
    }

    @ManyToOne
    @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia", nullable = false)
    public ProvinciaEntity getProvinciaByIdProvincia() {
        return provinciaByIdProvincia;
    }

    public void setProvinciaByIdProvincia(ProvinciaEntity provinciaByIdProvincia) {
        this.provinciaByIdProvincia = provinciaByIdProvincia;
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
