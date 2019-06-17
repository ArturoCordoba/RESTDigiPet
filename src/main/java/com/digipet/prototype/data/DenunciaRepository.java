package com.digipet.prototype.data;

import com.digipet.prototype.orm.DenunciaEntity;
import org.hibernate.Session;

import java.sql.Date;

public class DenunciaRepository {

    /**
     * Método que llama al Store Procedure de INSERTAR_DENUNCIA
     * @param cliente cliente denunciante
     * @param cuidador cuidador denunciado
     * @param descripcion descripción de la denuncia
     */
    public static void insertarDenunciaSP(int cliente, int cuidador, String descripcion){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_DENUNCIA(:Icliente,:Icuidador,:Ddescripcion)")
                    .addEntity(DenunciaEntity.class)
                    .setParameter("Icliente",cliente)
                    .setParameter("Icuidador",cuidador)
                    .setParameter("Ddescripcion",descripcion);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarDenunciaSP");
            throw e;
        }
    }
}
