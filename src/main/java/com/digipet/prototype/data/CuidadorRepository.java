package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.CuidadorDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.BadgeXCuidadorEntity;
import com.digipet.prototype.orm.CuidadorEntity;
import com.digipet.prototype.orm.ProvinciaXCuidadorEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Date;
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
     * @param cuidador Objeto DTO con la informacion del cuidador
     */
    public static void registrarCuidadorSP(CuidadorDTO cuidador){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            Date date = new Date();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL REGISTRAR_CUIDADOR(:Pnombre,:Papellido,:Sapellido,:Iprovincia,:Ccanton,:Iuniversidad," +
                            ":Ccarne,:Correo1,:Correo2,:Telefono,:Foto,:Ccontrasena,:Ddescripcion,:Op_provincia,:Fecha)")
                    .addEntity(CuidadorEntity.class)
                    .setParameter("Pnombre",cuidador.getPrimerNombre())
                    .setParameter("Papellido",cuidador.getPrimerApellido())
                    .setParameter("Sapellido",cuidador.getSegundoApellido())
                    .setParameter("Iprovincia",cuidador.getProvinciaResidencia())
                    .setParameter("Ccanton",cuidador.getCanton())
                    .setParameter("Iuniversidad",cuidador.getNombreUniversidad())
                    .setParameter("Ccarne",cuidador.getCarne())
                    .setParameter("Correo1",cuidador.getEmail1())
                    .setParameter("Correo2",cuidador.getEmail2())
                    .setParameter("Telefono",cuidador.getTelefonoMovil())
                    .setParameter("Foto",cuidador.getFotoPerfil())
                    .setParameter("Ccontrasena",cuidador.getContraseña())
                    .setParameter("Ddescripcion",cuidador.getDescripcion())
                    .setParameter("Op_provincia",cuidador.isOpcionProvincias())
                    .setParameter("Fecha",date.toString());

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

    private static CuidadorDTO convertToDTO(UsuarioEntity usuario, CuidadorEntity cuidador){
        CuidadorDTO cuidadorDTO = new CuidadorDTO();

        cuidadorDTO.setIdUsuario(usuario.getIdUsuario());
        cuidadorDTO.setPrimerNombre(usuario.getPrimerNombre());
        cuidadorDTO.setPrimerApellido(usuario.getPrimerApellido());
        cuidadorDTO.setSegundoApellido(usuario.getSegundoApellido());
        cuidadorDTO.setEmail1(usuario.getEmail1());
        cuidadorDTO.setContraseña(usuario.getContrasena());
        cuidadorDTO.setFotoPerfil(usuario.getFotoPerfil());
        cuidadorDTO.setIdRol(usuario.getIdUsuario());
        cuidadorDTO.setIdEstado(usuario.getEstado().getIdEstado());
        cuidadorDTO.setCarne(cuidador.getCarne());
        cuidadorDTO.setTelefonoMovil(cuidador.getTelefonoMovil());
        cuidadorDTO.setOpcionProvincias(cuidador.isOpcionProvincias());
        cuidadorDTO.setEmail2(cuidador.getEmail2());
        cuidadorDTO.setDescripcion(cuidador.getDescripcion());
        cuidadorDTO.setFechaInscripcion(cuidador.getFechaInscripcion().toString());
        cuidadorDTO.setNombreUniversidad(cuidador.getUniversidad().getNombre());

        return cuidadorDTO;
    }
}