package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.MascotaDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.MascotaEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;

public class MascotRepository {

    public static ArrayList<MascotaEntity> getAllMascotas() {
        ArrayList<MascotaEntity> data;

        Session session = HibernateSession.openSession();

        try {
            Query query = session.createQuery("FROM " + "MascotaEntity");
            data = (ArrayList<MascotaEntity>) query.getResultList();

        } catch (Exception exception){
            System.out.println("Error no identificado en getAllMascots");
            throw exception;
        }

        return data;
    }

    public static MascotaDTO getMascota(int id) throws Exception{
        //Se obtiene la mascota respectivo
        MascotaEntity mascota = ORManager.obtenerObjetoPorID(id,MascotaEntity.class);

        if(mascota != null){
            MascotaDTO mascotaDTO = convertToDTO(mascota);
            return mascotaDTO;
        } else {
            throw new Exception();
        }
    }

    private static MascotaDTO convertToDTO(MascotaEntity mascota) {
        MascotaDTO mascotaDTO = new MascotaDTO();
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
}
