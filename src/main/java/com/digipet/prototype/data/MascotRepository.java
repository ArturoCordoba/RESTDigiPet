package com.digipet.prototype.data;

import com.digipet.prototype.orm.MascotaEntity;
import org.hibernate.Session;

import java.sql.Date;

public class MascotRepository {

    public static void registrarMascotaSP(int cliente, String nombre, String raza,
                                          int edad, String tamaño, String descripcion, Date fecha){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL REGISTRAR_MASCOTA(:Icliente,:Mnombre,:Rraza,:Eedad,:Ttamaño,:Ddescripcion,:Fecha)")
                    .addEntity(MascotaEntity.class)
                    .setParameter("Icliente",cliente)
                    .setParameter("Mnombre",nombre)
                    .setParameter("Rraza",raza)
                    .setParameter("Eedad",edad)
                    .setParameter("Ttamaño",tamaño)
                    .setParameter("Ddescripcion",descripcion)
                    .setParameter("Fecha",fecha);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de registrarMascotaSP");
            throw e;
        }
    }
}
