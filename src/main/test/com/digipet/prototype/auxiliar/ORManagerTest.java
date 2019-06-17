package com.digipet.prototype.auxiliar;

import com.digipet.prototype.orm.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ORManagerTest {

    @Test
    public void crearObjeto() { //Cambiar el objeto durante cada prueba
        RolEntity rol = new RolEntity();
        rol.setIdRol(2);
        rol.setNombre("Cliente");

        EstadoEntity estado = new EstadoEntity();
        estado.setIdEstado(0);
        estado.setNombre("Activado");

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setPrimerNombre("Usuario");
        usuarioEntity.setPrimerApellido("Sin");
        usuarioEntity.setSegundoApellido("Nombre");
        usuarioEntity.setRol(rol);
        usuarioEntity.setEstado(estado);
        usuarioEntity.setEmail1("yo@latinlover.es");
        usuarioEntity.setContrasena("contra8");
        usuarioEntity.setFotoPerfil("penege.png");

        //ORManager.crearObjeto(usuarioEntity);
    }

    @Test
    public void ejecutarSelect() {
    }

    @Test
    public void obtenerTabla() {
        ArrayList<ClienteEntity> list = com.digipet.prototype.auxiliar.ORManager.obtenerTabla("ClienteEntity");

    }

    @Test
    public void obtenerObjetoPorID() {
        ClienteEntity clienteEntity = (ClienteEntity) com.digipet.prototype.auxiliar.ORManager.obtenerObjetoPorID(2,ClienteEntity.class);
    }
}