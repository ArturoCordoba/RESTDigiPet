package com.digipet.prototype.data;

import com.digipet.prototype.orm.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class HibernateUtil {
    private static SessionFactory sessionFactory;

    /**
     * Metodo que inicializa la conexion y establece la configuracion con MariaDB
     */
    private static void buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        //Se registran las clases que deben ser mapeadas con cada tabla de la BD
        configuration.addAnnotatedClass(BadgeEntity.class);
        configuration.addAnnotatedClass(BadgeXCuidadorEntity.class);
        configuration.addAnnotatedClass(ClienteEntity.class);
        configuration.addAnnotatedClass(CuidadorEntity.class);
        configuration.addAnnotatedClass(DenunciaEntity.class);
        configuration.addAnnotatedClass(DisponibilidadXCuidadorEntity.class);
        configuration.addAnnotatedClass(EstadoEntity.class);
        configuration.addAnnotatedClass(FotoXMascotaEntity.class);
        configuration.addAnnotatedClass(FotoXReporteEntity.class);
        configuration.addAnnotatedClass(HotelEntity.class);
        configuration.addAnnotatedClass(MascotaEntity.class);
        configuration.addAnnotatedClass(PagoXClienteEntity.class);
        configuration.addAnnotatedClass(ProvinciaEntity.class);
        configuration.addAnnotatedClass(ProvinciaXCuidadorEntity.class);
        configuration.addAnnotatedClass(ReporteEntity.class);
        configuration.addAnnotatedClass(RolEntity.class);
        configuration.addAnnotatedClass(ServicioEntity.class);
        configuration.addAnnotatedClass(SolicitudEntity.class);
        configuration.addAnnotatedClass(SolicitudXCuidadorEntity.class);
        configuration.addAnnotatedClass(SolicitudXHotelEntity.class);
        configuration.addAnnotatedClass(TamanoEntity.class);
        configuration.addAnnotatedClass(UniversidadEntity.class);
        configuration.addAnnotatedClass(UsuarioEntity.class);
        
        // . . .

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Metodo que se encarga de verificar si la factoria de sesiones ya ha sido creada
     * Se utiliza un Doble-Check Singlenton
     */
    private static void buildSession(){
        synchronized (HibernateUtil.class){
            if(sessionFactory == null){
                synchronized (HibernateUtil.class){
                    if(sessionFactory == null)
                        buildSessionFactory();
                }
            }
        }
    }

    /**
     * Metodo para abrir una nueva sesion
     */
    public static Session openSession() {
        buildSession();

        return sessionFactory.openSession();
    }
}
