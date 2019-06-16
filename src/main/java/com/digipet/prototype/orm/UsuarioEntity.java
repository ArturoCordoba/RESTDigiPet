package com.digipet.prototype.orm;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USUARIO", schema = "digipet", catalog = "")
public class UsuarioEntity {
    private int idUsuario;
    private String primerNombre;
    private String primerApellido;
    private String segundoApellido;
    private int idRol;
    private String email1;
    private String contrasena;
    private String fotoPerfil;
    private int idEstado;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Id_usuario", nullable = false)
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "Primer_nombre", nullable = false, length = 30)
    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    @Basic
    @Column(name = "Primer_apellido", nullable = false, length = 30)
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Basic
    @Column(name = "Segundo_apellido", nullable = true, length = 30)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Basic
    @Column(name = "Id_rol", nullable = false)
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Basic
    @Column(name = "Email_1", nullable = false, length = 30)
    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    @Basic
    @Column(name = "Contrasena", nullable = false, length = 8)
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Basic
    @Column(name = "Foto_perfil", nullable = false, length = 30)
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Basic
    @Column(name = "Id_estado", nullable = false)
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return idUsuario == that.idUsuario &&
                idRol == that.idRol &&
                idEstado == that.idEstado &&
                Objects.equals(primerNombre, that.primerNombre) &&
                Objects.equals(primerApellido, that.primerApellido) &&
                Objects.equals(segundoApellido, that.segundoApellido) &&
                Objects.equals(email1, that.email1) &&
                Objects.equals(contrasena, that.contrasena) &&
                Objects.equals(fotoPerfil, that.fotoPerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, primerNombre, primerApellido, segundoApellido, idRol, email1, contrasena, fotoPerfil, idEstado);
    }
}
