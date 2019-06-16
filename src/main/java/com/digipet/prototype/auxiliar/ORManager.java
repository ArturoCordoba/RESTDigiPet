package com.digipet.prototype.auxiliar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ORManager<T> {

    private final Class<T> typeParameterClass;
    private final T object;

    public ORManager(Class<T> typeParameterClass, T object) {
        this.typeParameterClass = typeParameterClass;
        this.object = object;
    }


    public void crearObjeto(){
        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            session.save(this.object);
            session.getTransaction().commit();

            session.close();
            sessionFactory.close();

        } catch (org.hibernate.MappingException exception){
            System.out.println("Tipo de clase inválido: debe ser un objeto de clase \'Entity\'");
            throw exception;
        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }
    }

    public List<T> obtenerTabla(String queryString){

        List<T> data; //Navigate the object using an iterator

        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(typeParameterClass);
            criteria.from(typeParameterClass);
            data = session.createQuery(criteria).getResultList();

            session.close();
            sessionFactory.close();

        } catch (org.hibernate.MappingException exception){
            System.out.println("Tipo de clase inválido: debe ser un objeto de clase \'Entity\'");
            throw exception;
        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }

        return data;
    }

    public T obtenerObjeto(int identificador){

        T data;

        try {
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            data = session.get(this.typeParameterClass, identificador);

            session.close();
            sessionFactory.close();

        } catch (org.hibernate.MappingException exception){
            System.out.println("Tipo de clase inválido: debe ser un objeto de clase \'Entity\'");
            throw exception;
        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }

        return data;
    }
}
