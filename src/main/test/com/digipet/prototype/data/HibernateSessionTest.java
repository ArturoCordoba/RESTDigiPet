package com.digipet.prototype.data;

import com.digipet.prototype.api.authentication.Role;
import com.digipet.prototype.orm.EstadoEntity;
import com.digipet.prototype.orm.RolEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateSessionTest {

    @Test
    public void saveObject() {
        EstadoEntity estadoEntity = new EstadoEntity();
        estadoEntity.setIdEstado(0);
        estadoEntity.setNombre("Activado");

        RolEntity rolEntity = new RolEntity();
        rolEntity.setIdRol(1);
        rolEntity.setNombre("Administrador");

        UsuarioEntity user = new UsuarioEntity();

        user.setPrimerNombre("Jorge");
        user.setPrimerApellido("Rogers");
        user.setSegundoApellido("Rojas");
        user.setEmail1("jorgerr1@gmail.com");
        user.setContrasena("pass123");
        user.setFotoPerfil("jrr.png");
        user.setEstado(estadoEntity);
        user.setRol(rolEntity);


    }

    @Test
    public void deleteObject(){
        EstadoEntity estadoEntity = new EstadoEntity();
        estadoEntity.setIdEstado(0);
        estadoEntity.setNombre("Activado");

        RolEntity rolEntity = new RolEntity();
        rolEntity.setIdRol(1);
        rolEntity.setNombre("Administrador");

        UsuarioEntity user = new UsuarioEntity();

        user.setPrimerNombre("Jorge");
        user.setPrimerApellido("Rogers");
        user.setSegundoApellido("Rojas");
        user.setEmail1("jorgerr1@gmail.com");
        user.setContrasena("pass123");
        user.setFotoPerfil("jrr.png");
        user.setEstado(estadoEntity);
        user.setRol(rolEntity);


        user.setIdUsuario(23);

        /*Session session = HibernateSession.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();*/


    }


}