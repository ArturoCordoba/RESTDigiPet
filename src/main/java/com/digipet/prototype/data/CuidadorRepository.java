package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.CuidadorDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.BadgeXCuidadorEntity;
import com.digipet.prototype.orm.CuidadorEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;

public class CuidadorRepository {

    /**
     * Método que obtiene la la tabla de cuidadores
     * @return ArrayList de cuidadores
     */
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

    /**
     * Método que retorna un cuidador según su id
     * @param id del cuidador
     * @return cuidador a quien pertenece el id
     * @throws Exception Si el cuidador o usuario son nulos
     */
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

    /**
     * Método que llama al Store Procedure de REGISTRAR_CUIDADOR
     * @param nombre nombre del cuidador
     * @param primerApellido primer apellido del cuidador
     * @param segundoApellido segundo apellido del cuidador
     * @param provincia provincia de residencia del cuidador
     * @param canton cantón de residencia del cuidador
     * @param universidad universidad de estudio del cuidador
     * @param carne carne de universidad del cuidador
     * @param correo1 correo primario del cuidador
     * @param correo2 correo secundario del cuidador (puede estar vacío)
     * @param telefono teléfono del cuidador
     * @param foto foto de perfil del cuidador
     * @param contrasena contraseña del cuidador
     * @param descripcion descripción del cuidador
     * @param opProvincia provincias adicionales donde el cuidador puede laborar
     * @param fecha fecha de inscripción del cuidador
     */
    public static void registrarCuidadorSP(String nombre, String primerApellido, String segundoApellido,
                                           String provincia, String canton, String universidad, String carne,
                                           String correo1, String correo2, String telefono, String foto,
                                           String contrasena, String descripcion, String opProvincia, Date fecha){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            if (correo2 == null) correo2 = "";

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

    /**
     * Método que llama al Store Procedure de INSERTAR_BADGE_CUIDADOR
     * @param cuidador cuidador a quien pertenece el nuevo badge
     * @param badge badge a asignar al cuidador
     */
    public static void insertarBadgeCuidadorSP(int cuidador, int badge){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_BADGE_CUIDADOR(:Icuidador,:Ibadge)")
                    .addEntity(BadgeXCuidadorEntity.class)
                    .setParameter("Icuidador",cuidador)
                    .setParameter("Ibadge",badge);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarBagdeCuidador");
            throw e;
        }
    }
}
