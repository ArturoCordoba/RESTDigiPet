package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USUARIO", schema = "digipet")
public class UsuarioEntity {
    private int idUsuario;
    private String primerNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email1;
    private String contrasena;
    private String fotoPerfil;
    private RolEntity rol;
    private EstadoEntity estado;

    @Id
    @Column(name = "Id_usuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "Primer_nombre")
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    @Basic
    @Column(name = "Primer_apellido")
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Basic
    @Column(name = "Segundo_apellido")
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Basic
    @Column(name = "Email_1")
    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    @Basic
    @Column(name = "Contrasena")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Basic
    @Column(name = "Foto_perfil")
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario &&
                Objects.equals(primerNombre, that.primerNombre) &&
                Objects.equals(primerApellido, that.primerApellido) &&
                Objects.equals(segundoApellido, that.segundoApellido) &&
                Objects.equals(email1, that.email1) &&
                Objects.equals(contrasena, that.contrasena) &&
                Objects.equals(fotoPerfil, that.fotoPerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, primerNombre, primerApellido, segundoApellido, email1, contrasena, fotoPerfil);
    }

    @ManyToOne
    @JoinColumn(name = "Id_rol", referencedColumnName = "Id_rol", nullable = false)
    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    @ManyToOne
    @JoinColumn(name = "Id_estado", referencedColumnName = "Id_estado", nullable = false)
    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }
}
