package com.digipet.prototype.auxiliar;

import org.junit.Test;
import com.digipet.prototype.orm.BadgeEntity;
import com.digipet.prototype.orm.MascotaEntity;
import com.digipet.prototype.orm.UsuarioEntity;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ORManagerTest {

    @Test
    public void crearObjeto() { //Cambiar el objeto durante cada prueba
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setPrimerNombre("Usuario");
        usuarioEntity.setPrimerApellido("Sin");
        usuarioEntity.setSegundoApellido("Nombre");
        usuarioEntity.setIdRol(1);
        usuarioEntity.setEmail1("yo@latinlover.es");
        usuarioEntity.setContrasena("contra8");
        usuarioEntity.setFotoPerfil("penege.png");

        ORManager.crearObjeto(usuarioEntity, UsuarioEntity.class);
    }


    @Test
    public void ejecutarSelect() {
    }

    @Test
    public void registrarClienteSP() {
        String datestr = "2015-03-31";
        Date date = Date.valueOf(datestr);
        com.digipet.prototype.auxiliar.ORManager.registrarClienteSP("Gutierrez","Casimiro,",
                "Alfaro","Alajuela","Alajuela","no@correo","","87655432",
                "nohay.jpg","laprogre","Salu2",date);
    }
}