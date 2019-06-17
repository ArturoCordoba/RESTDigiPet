package com.digipet.prototype.auxiliar;

import com.digipet.prototype.orm.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import java.sql.Date;
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

        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(RolEntity.class)
                .addAnnotatedClass(EstadoEntity.class)
                .addAnnotatedClass(UsuarioEntity.class);
        ORManager.crearObjeto(usuarioEntity, configuration);
    }


    @Test
    public void ejecutarSelect() {
    }

    @Test
    public void registrarClienteSP() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(PagoXClienteEntity.class)
                .addAnnotatedClass(HotelEntity.class)
                .addAnnotatedClass(SolicitudXHotelEntity.class)
                .addAnnotatedClass(ProvinciaXCuidadorEntity.class)
                .addAnnotatedClass(DisponibilidadXCuidadorEntity.class)
                .addAnnotatedClass(BadgeEntity.class)
                .addAnnotatedClass(BadgeXCuidadorEntity.class)
                .addAnnotatedClass(UniversidadEntity.class)
                .addAnnotatedClass(CuidadorEntity.class)
                .addAnnotatedClass(SolicitudXCuidadorEntity.class)
                .addAnnotatedClass(FotoXReporteEntity.class)
                .addAnnotatedClass(ReporteEntity.class)
                .addAnnotatedClass(ServicioEntity.class)
                .addAnnotatedClass(SolicitudEntity.class)
                .addAnnotatedClass(FotoXMascotaEntity.class)
                .addAnnotatedClass(TamanoEntity.class)
                .addAnnotatedClass(ProvinciaEntity.class)
                .addAnnotatedClass(EstadoEntity.class)
                .addAnnotatedClass(RolEntity.class)
                .addAnnotatedClass(MascotaEntity.class)
                .addAnnotatedClass(ClienteEntity.class)
                .addAnnotatedClass(UsuarioEntity.class);

        String dateSTR = "2015-03-31";
        Date date = Date.valueOf(dateSTR);
        com.digipet.prototype.auxiliar.ORManager.registrarClienteSP("Gutierrez","Casimiro,",
                "Alfaro","Alajuela","Alajuela","no@correo","","87655432",
                "nohay.jpg","laprogre","Salu2",date,configuration);
    }
}