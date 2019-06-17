package com.digipet.prototype.auxiliar;

import com.digipet.prototype.orm.ClienteEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Date;
import java.util.List;

/**
 * Controlador que maneja las comuicaciones de los ClassEntity con la base de datos
 */
public class ORManager {

    /**
     * Método para crear un objeto en la base de datos. El objeto a guardar es el instanciado en el constructor
     * @param object objeto a agregar a la base de datos
     * @param configuration objeto de configuración con las clases necesarias anotadas
     * @param <T> tipo de clase
     * @throws IllegalArgumentException Cuando el objeto es nulo
     */
    public static <T> void crearObjeto(T object, Configuration configuration) throws IllegalArgumentException{

        if (object == null) throw new IllegalArgumentException("Intento de crear un objeto cuando su valor es nulo.");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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
     ** Método que ejecuta un Query de selección dado según la entrada
     * @param string Query a ejecutar
     * @param configuration objeto de configuración con las clases necesarias anotadas
     * @return Una lista con los resultados del query
     */
    public static List ejecutarSelect(String string, Configuration configuration){
        List data;

        try {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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

    public static void registrarClienteSP(String Pnombre, String Papellido, String Sapellido,
                                              String Iprovincia, String Ccanton, String Correo1, String Correo2,
                                              String Telefono, String Foto, String Contrasena, String Ddescripcion,
                                              Date Fecha, Configuration configuration){
        try {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            Query query = session.createSQLQuery(
                    "CALL REGISTRAR_CLIENTE(:Pnombre,:Papellido,:Sapellido,:Iprovincia,:Ccanton," +
                            ":Correo1,:Correo2,:Telefono,:Foto,:Contrasena,:Ddescripcion,:Fecha)")
                    .addEntity(UsuarioEntity.class)
                    .addEntity(ClienteEntity.class)
                    .setParameter("Pnombre",Pnombre)
                    .setParameter("Papellido",Papellido)
                    .setParameter("Sapellido",Sapellido)
                    .setParameter("Iprovincia",Iprovincia)
                    .setParameter("Ccanton",Ccanton)
                    .setParameter("Correo1",Correo1)
                    .setParameter("Correo2",Correo2)
                    .setParameter("Telefono",Telefono)
                    .setParameter("Foto",Foto)
                    .setParameter("Contrasena", Contrasena)
                    .setParameter("Ddescripcion",Ddescripcion)
                    .setParameter("Fecha",Fecha);

            query.executeUpdate();

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
