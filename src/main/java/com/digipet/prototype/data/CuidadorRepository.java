package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.CuidadorDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.CuidadorEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;

public class CuidadorRepository {

    public static ArrayList<CuidadorEntity> getAllCuidadores() {
        ArrayList<CuidadorEntity> data;

        Session session = HibernateSession.openSession();

        try {
            Query query = session.createQuery("FROM " + "CuidadorEntity");
            data = (ArrayList<CuidadorEntity>) query.getResultList();

        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }

        return data;
    }

    public static CuidadorDTO getCuidador(int id) throws Exception{
        //Se obtiene el cuidador respectivo
        CuidadorEntity cuidador = ORManager.obtenerObjetoPorID(id,CuidadorEntity.class);

        UsuarioEntity user = ORManager.obtenerObjetoPorID(id,UsuarioEntity.class);

        if(cuidador != null && user != null){
            CuidadorDTO cuidadorDTO = convertToDTO(user, cuidador);
            return cuidadorDTO;
        } else {
            throw new Exception();
        }
    }

    public static void registrarCuidadorSP(String nombre, String primerApellido, String segundoApellido,
                                           String provincia, String canton, String universidad, String carne,
                                           String correo1, String correo2, String telefono, String foto,
                                           String contrasena, String descripcion, String opProvincia, Date fecha){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            if (correo2==null) correo2 = "";

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
