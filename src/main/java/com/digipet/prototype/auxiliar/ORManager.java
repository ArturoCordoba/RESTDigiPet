package com.digipet.prototype.auxiliar;

import com.digipet.prototype.orm.ClienteEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.sql.Date;


/**
 * Controlador que maneja las comuicaciones de los ClassEntity con la base de datos
 */
public class ORManager {

    /**
     * Método para crear un objeto en la base de datos. El objeto a guardar es el instanciado en el constructor
     * @param object objeto a agregar a la base de datos
     * @param <T> tipo de clase
     * @throws IllegalArgumentException Cuando el objeto es nulo
     */
    public static <T> void crearObjeto(T object) throws IllegalArgumentException{

        if (object == null) throw new IllegalArgumentException("Intento de crear un objeto cuando su valor es nulo.");

        Session session = com.digipet.prototype.data.HibernateSession.openSession();

        try {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();

            session.close();

        } catch (Exception exception){
            System.out.println("Error no identificado al crear objeto");
            throw exception;
        }
    }

    /**
     * Método que retorna una lista con todas las instancias de la clase
     * @return lista de objetos
     */
    public static <T> ArrayList<T> obtenerTabla(String tabla){

        ArrayList<T> data;

        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();
            Query query = session.createQuery("FROM " + tabla);
            data = (ArrayList<T>) query.getResultList();

            session.close();

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
     */
    public static <T> T obtenerObjetoPorID(int identificador, Class<T> tClass){

        T data;

        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();
            session.beginTransaction();
            data = session.get(tClass, identificador); //TODO: excepción identificador inválido

            session.close();

        } catch (Exception exception){
            System.out.println(exception.toString());
            throw exception;
        }
        return data;
    }
}
