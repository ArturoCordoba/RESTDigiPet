package com.digipet.prototype.orm;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE", schema = "digipet")
public class ClienteEntity {
    private int idCliente;
    private String telefonoMovil;
    private String canton;
    private String email2;
    private String descripcion;
    private Date fechaInscripcion;
    private UsuarioEntity usuario;
    private ProvinciaEntity provincia;
    private List<MascotaEntity> listaMascotas;
    private List<PagoXClienteEntity> listaPago;
    private List<SolicitudEntity> listaSolicitudes;

    @Id
    @Column(name = "Id_cliente", nullable = false)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "Telefono_movil", nullable = false, length = 10)
    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @Basic
    @Column(name = "Canton")
    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    @Basic
    @Column(name = "Email_2", nullable = true, length = 30)
    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    @Basic
    @Column(name = "Descripcion", nullable = false, length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Fecha_Inscripcion", nullable = false)
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return idCliente == that.idCliente &&
                Objects.equals(telefonoMovil, that.telefonoMovil) &&
                Objects.equals(canton, that.canton) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(fechaInscripcion, that.fechaInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, telefonoMovil, canton, email2, descripcion, fechaInscripcion);
    }

    @OneToOne
    @JoinColumn(name = "Id_cliente", referencedColumnName = "Id_usuario", nullable = false)
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "Id_provincia", referencedColumnName = "Id_provincia", nullable = false)
    public ProvinciaEntity getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaEntity provincia) {
        this.provincia = provincia;
    }

    @OneToMany(mappedBy = "cliente")
    public List<MascotaEntity> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<MascotaEntity> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    @OneToMany(mappedBy = "cliente")
    public List<PagoXClienteEntity> getListaPago() {
        return listaPago;
    }

    public void setListaPago(List<PagoXClienteEntity> listaPago) {
        this.listaPago = listaPago;
    }

    @OneToMany(mappedBy = "cliente")
    public List<SolicitudEntity> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<SolicitudEntity> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
}
