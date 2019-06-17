package com.digipet.prototype.data;

import com.digipet.prototype.orm.CuidadorEntity;
import org.hibernate.Session;

import java.sql.Date;

public class CuidadorRepository {

    public static void registrarCuidadorSP(String nombre, String primerApellido, String segundoApellido,
                                           String provincia, String canton, String universidad, String carne,
                                           String correo1, String correo2, String telefono, String foto,
                                           String contrasena, String descripcion, String opProvincia, Date fecha){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL REGISTRAR_CUIDADOR(:Pnombre,:Papellido,:Sapellido,:Iprovincia,:Ccanton,:Iuniversidad," +
                            ":Ccarne,:Correo1,:Correo2,:Telefono,:Foto,:Ccontrasena,:Ddescripcion,:Op_provincia,:Fecha)")
                    .addEntity(CuidadorEntity.class)
                    .setParameter("Pnombre",nombre)
                    .setParameter("Papellido",primerApellido)
                    .setParameter("Sapellido",segundoApellido)
                    .setParameter("Iprovincia",provincia)
                    .setParameter("Ccanton",canton)
                    .setParameter("Iuniversidad",universidad)
                    .setParameter("Ccarne",carne)
                    .setParameter("Correo1",correo1)
                    .setParameter("Correo2",correo2)
                    .setParameter("Telefono",telefono)
                    .setParameter("Foto",foto)
                    .setParameter("Ccontrasena",contrasena)
                    .setParameter("Ddescripcion",descripcion)
                    .setParameter("Op_provincia",opProvincia)
                    .setParameter("Fecha",fecha);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de registrarCuidadorSP");
            throw e;
        }
    }
}
