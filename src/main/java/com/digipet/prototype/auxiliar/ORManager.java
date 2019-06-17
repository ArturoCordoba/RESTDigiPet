package com.digipet.prototype.auxiliar;

import com.digipet.prototype.data.HibernateSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador que maneja las comuicaciones de los ClassEntity con la base de datos
 * @param <T> tipo del objeto a comunicar
 */
public class ORManager<T> {

    private final Class<T> typeParameterClass; //Clase del objeto
    private final T object; //Objeto a comunicar
    private final Session session; //Session necesario para la comunicación

    /**
     * Constructor del ORManager
     * @param typeParameterClass clase del objeto
     * @param object objeto a comunicar
     */
    public ORManager(Class<T> typeParameterClass, T object) {
        this.typeParameterClass = typeParameterClass;
        this.object = object;
        try {
            session = HibernateSession.openSession();
        } catch (Exception e){
            System.out.println("Error al crear servicio en el constructor");
            throw e;
        }
    }

    /**
     * Método para crear un objeto en la base de datos. El objeto a guardar es el instanciado en el constructor
     */
    public void crearObjeto() throws IllegalArgumentException{

        if (this.object == null) throw new IllegalArgumentException("Intento de crear un objeto cuando su valor es nulo.");

        try {
            session.beginTransaction();
            session.save(this.object);
            session.getTransaction().commit();

            session.close();

        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }
    }

    /**
     * Método que retorna una lista con todas las instancias de la clase
     * @return lista de objetos
     */
    public ArrayList<T> obtenerTabla(String tabla){

        ArrayList<T> data;

        try {
            Query query = session.createQuery("FROM " + tabla);
            data = (ArrayList<T>) query.getResultList();

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
    public T obtenerObjetoPorID(int identificador){

        T data;

        try {
            session.beginTransaction();
            data = session.get(this.typeParameterClass, identificador); //TODO: excepción identificador inválido

            session.close();

        } catch (Exception exception){
            System.out.println(exception.toString());
            throw exception;
        }
        return data;
    }
}
