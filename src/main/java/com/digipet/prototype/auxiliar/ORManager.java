package com.digipet.prototype.auxiliar;

import com.digipet.prototype.orm.ClienteEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Date;
import java.util.List;

/**
 * Controlador que maneja las comuicaciones de los ClassEntity con la base de datos
 */
public class ORManager {

    /**
     * Método que crea un SessionFactory para la comunicación con la base de datos
     * @param <T> tipo de clase
     * @return instancia de SessionFactory
     */
    private static <T> SessionFactory crearSesionUno(Class<T> tClass) {
        try {
            Configuration configuration = new Configuration().configure().addAnnotatedClass(tClass);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e){
            System.out.println("Error al crear servicio en el creador de sesiones");
            throw e;
        }
    }

    /**
     * Método para crear un objeto en la base de datos. El objeto a guardar es el instanciado en el constructor
     * @param object objeto a agregar a la base de datos
     * @param <T> tipo de clase
     * @throws IllegalArgumentException Cuando el objeto es nulo
     */
    public static <T> void crearObjeto(T object, Class<T> tClass) throws IllegalArgumentException{

        if (object == null) throw new IllegalArgumentException("Intento de crear un objeto cuando su valor es nulo.");

        SessionFactory sessionFactory = crearSesionUno(tClass);
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();

            session.close();
            sessionFactory.close();

        } catch (Exception exception){
            System.out.println("Error no identificado al crear objeto");
            throw exception;
        }
    }

    /**
     * Método que ejecuta un Query de selección dado según la entrada
     * @param string Query a ejecutar
     * @param tClass clase de la tabla a la que está mapeada
     * @param <T> tipo de clase
     * @return Una lista con los resultados del query
     */
    public static <T> List ejecutarSelect(String string, Class<T> tClass){
        List data;

        try {
            SessionFactory sessionFactory = crearSesionUno(tClass);
            Session session = sessionFactory.openSession();

            data = session.createQuery(string).list();

            session.close();
            sessionFactory.close();
        } catch (Exception e){
            System.out.println("Error no identificado al ejecutar el Query SELECT");
            throw e;
        }

        return data;
    }

    public static void registrarClienteSP(String nombre, String primerApellido, String segundoApellido,
                                              String provincia, String canton, String correo1, String correo2,
                                              String telefono, String foto, String contrasena, String descripcion,
                                              Date fecha){
        try {
            Configuration configuration = new Configuration().configure()
                    .addAnnotatedClass(UsuarioEntity.class)
                    .addAnnotatedClass(ClienteEntity.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "CALL REGISTRAR_CLIENTE(:Pnombre,:Papellido,:Sapellido,:Iprovincia,:Ccanton," +
                            ":Correo1,:Correo2,:Telefono,:Foto,:Contrasena,:Ddescripcion,:Fecha)")
                    .addEntity(ClienteEntity.class).addEntity(UsuarioEntity.class)
                    .setParameter("Pnombre",nombre)
                    .setParameter("Papellido",primerApellido)
                    .setParameter("Sapellido",segundoApellido)
                    .setParameter("Iprovincia",provincia)
                    .setParameter("Ccanton",canton)
                    .setParameter("Correo1",correo1)
                    .setParameter("Correo2",correo2)
                    .setParameter("Telefono",telefono)
                    .setParameter("Foto",foto)
                    .setParameter("Contrasena", contrasena)
                    .setParameter("Ddescripcion",descripcion)
                    .setParameter("Fecha",fecha);

            query.list();

            session.getTransaction().commit();
            sessionFactory.close();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de registrarClienteSP");
            throw e;
        }
    }

    /**
     * Método que retorna una lista con todas las instancias de la clase
     * @return lista de objetos
     *
    List obtenerTabla(){

        List data; //Navigate the object using an iterator

        try {
            session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(this.typeParameterClass);
            criteria.from(this.typeParameterClass);
            data = session.createQuery(criteria).getResultList();

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();

        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }

        return data;
    }

    /**
     * Método que retorna el objeto según el id, de la tabla de la clase instanciada
     * @param identificador id del objeto a buscar en la base de datos
     * @return objeto encontrado //TODO: manejar retorno de objeto nulo
     *
    public T obtenerObjeto(int identificador){

        T data;

        try {
            session.beginTransaction();
            data = session.get(this.typeParameterClass, identificador); //TODO: excepción identificador inválido

            session.close();
            sessionFactory.close();

        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }

        return data;
    }
         */
}
