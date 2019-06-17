package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.MascotaDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.FotoXMascotaEntity;
import com.digipet.prototype.orm.MascotaEntity;
import com.digipet.prototype.orm.SolicitudEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MascotaRepository {

    /**
     * Método que obtiene la la tabla de mascotas
     * @return ArrayList de mascotas
     */
    public static List<MascotaDTO> getAllMascotas() {
        List<MascotaDTO> data = new ArrayList<>();

        Session session = HibernateSession.openSession();

        try {
            Query query = session.createQuery(
                    "from MascotaEntity m " +
                            "fetch all properties ");
            List mascotaList = query.getResultList();

            for (Object o : mascotaList) {
                MascotaEntity mascotaEntity = (MascotaEntity) o;
                data.add(convertToDTO(mascotaEntity));
            }

        } catch (NullPointerException nullpt){
          System.out.println("Error al pasar de Entity a DTO");
          throw nullpt;
        } catch (Exception exception){
            System.out.println("Error no identificado en getAllMascots");
            throw exception;
        }

        return data;
    }

    /**
     * Método que retorna una mascota según su id
     * @param id de la mascota
     * @return mascota a quien pertenece el id
     * @throws Exception Si la mascota es nula
     */
    public static MascotaDTO getMascota(int id) throws Exception{
        //Se obtiene la mascota respectivo
        MascotaEntity mascota = ORManager.obtenerObjetoPorID(id,MascotaEntity.class);
        MascotaDTO data;

        Session session = HibernateSession.openSession();

        try {
            Query query = session.createQuery(
                    "from MascotaEntity m " +
                            "fetch all properties " +
                            "where m.idMascota = :id")
                    .setParameter("id",id);

            data = convertToDTO((MascotaEntity) query.getSingleResult());

        } catch (Exception exception){
            System.out.println("Error no identificado en getAllMascots");
            throw exception;
        }

        return data;
    }

    private static MascotaDTO convertToDTO(MascotaEntity mascota) {
        MascotaDTO mascotaDTO = new MascotaDTO();

        List<FotoXMascotaEntity> listaFotosE = mascota.getListaFotos();
        List<String> listaFotos = new ArrayList<>();

        if(listaFotosE != null){
            //Se convierte la lista de fotos obtenida de la entidad
            for (int i = 0; i < listaFotosE.size(); i++) {
                listaFotos.add(listaFotosE.get(i).getFoto());
            }
        }

        List<SolicitudEntity> listaSolicitudEntity = mascota.getListaSolicitudes();
        List<Integer> listaIdSolicitudes = new ArrayList<>();

        for (int i = 0; i < listaSolicitudEntity.size(); i++) {
            listaIdSolicitudes.add(listaSolicitudEntity.get(i).getIdSolicitud());
        }

        mascotaDTO.setId_mascota(mascota.getIdMascota());
        mascotaDTO.setNombre(mascota.getNombre());
        mascotaDTO.setRaza(mascota.getRaza());
        mascotaDTO.setEdad(mascota.getEdad());
        mascotaDTO.setDescripcion(mascota.getDescripcion());
        mascotaDTO.setFechaInscripcion(mascota.getFechaInscripcion().toString());
        mascotaDTO.setListaFotos(listaFotos);
        mascotaDTO.setListaIdSolicitudes(listaIdSolicitudes);

        return mascotaDTO;
    }

    /**
     * Método que llama al Store Procedure de REGISTRAR_MASCOTA
     * @param cliente id del dueño de la mascota
     * @param nombre nombre de la mascota
     * @param raza raza de la mascota
     * @param edad edad de la mascota
     * @param tamaño tamaño de la mascota (S, M, L o XL)
     * @param descripcion descripción de la mascota
     * @param fecha fecha de inscripción de la mascota
     */
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

    /**
     * Método que llama al Store Procedure de INSERTAR_FOTO_PERFIL
     * @param mascota mascota a quien corresponde la foto
     * @param foto url de la foto a insertar
     */
    public static void insertarFotoMascotaSP(int mascota, String foto){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_FOTO_MASCOTA(:Imascota,:Foto_masc)")
                    .addEntity(FotoXMascotaEntity.class)
                    .setParameter("Imascota",mascota)
                    .setParameter("Foto_masc",foto);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarFotoMascotaSP");
            throw e;
        }
    }
}
