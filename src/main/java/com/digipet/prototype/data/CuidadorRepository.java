package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.CuidadorDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.BadgeXCuidadorEntity;
import com.digipet.prototype.orm.CuidadorEntity;
import com.digipet.prototype.orm.ProvinciaXCuidadorEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CuidadorRepository {

    /**
     * Método que obtiene la la tabla de cuidadores
     * @return ArrayList de cuidadores
     */
    public static List getAllCuidadores() {
        List<CuidadorDTO> data = null;
        List cuidadores;

        Session session = HibernateSession.openSession();

        try {
            Query query = session.createQuery("FROM " + "CuidadorEntity");
            cuidadores = query.getResultList();

            for (Object cuidador : cuidadores) {
                CuidadorEntity cuidadorEntity = (CuidadorEntity) cuidador;
                UsuarioEntity usuarioEntity = ORManager.obtenerObjetoPorID(cuidadorEntity.getIdCuidador(), UsuarioEntity.class);
                data.add(convertToDTO(usuarioEntity, cuidadorEntity));
            }

        } catch (NullPointerException nullptr){
            System.out.println("Error de puntero al convertir en DTO");
            throw nullptr;
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
            System.out.println("Durante el procesamiento de insertarBagdeCuidadorSP");
            throw e;
        }
    }

    /**
     * Método que llama al Store Procedure de INSERTAR_PROVINCIA_CUIDADOR
     * @param cuidador cuidador residente
     * @param provincia provincia de residencia
     */
    public static void insertarProvinciaCuidadorSP(int cuidador, String provincia){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_PROVINCIA_CUIDADOR(:Icuidador,:Iprovincia)")
                    .addEntity(ProvinciaXCuidadorEntity.class)
                    .setParameter("Icuidador",cuidador)
                    .setParameter("Iprovincia",provincia);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarProvinciaCuidadorSP");
            throw e;
        }
    }
}
