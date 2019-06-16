package com.digipet.prototype.data;

import com.digipet.prototype.api.authentication.Role;
import com.digipet.prototype.orm.EstadoEntity;
import com.digipet.prototype.orm.RolEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateUtilTest {

    @Test
    public void openSession() {
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



        Session session = HibernateUtil.openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }


}