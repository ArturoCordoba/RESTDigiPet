package com.digipet.prototype.data;

import com.digipet.prototype.orm.SolicitudEntity;
import org.hibernate.Session;

import java.sql.Date;

public class SolicitudRepository {

    /**
     * Método que llama al Store Procedure de INSERTAR_SOLICITUD
     * @param horaInicio hora de inicio de la solicitud
     * @param horaFinal hora final de la solicitud
     * @param duracion duración de la solicitud
     * @param solicitud estado de la solicitud
     * @param precio precio total de la solicitud
     * @param cliente cliente que pide la solicitud
     * @param mascota mascota de la solicitud
     * @param servicio tipo de servicio
     * @param cuidador cuidador asignado
     * @param calificacion calificación recibida al cuidador
     * @param pago pago de la solicitud
     * @param direccion direccion de recolección
     * @param descripcion descripción de la solicitud
     */
    public static void insertarSolicitudSP(Date horaInicio, Date horaFinal, int duracion, String solicitud,
                                         float precio, int cliente, int mascota, int servicio, int cuidador,
                                         float calificacion, String pago, String direccion, String descripcion){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_SOLICITUD(:FHora_inicio,:FHora_final,:Dduracion,:Esolicitud,:Precio,:Icliente," +
                            ":Imascota,:Iservicio,:Icuidador,:Calif,:Pago,:Dir,:Ddescripcion)")
                    .addEntity(SolicitudEntity.class)
                    .setParameter("FHora_inicio", horaInicio)
                    .setParameter("FHora_final",horaFinal)
                    .setParameter("Dduracion",duracion)
                    .setParameter("Esolicitud",solicitud)
                    .setParameter("Precio",precio)
                    .setParameter("Icliente",cliente)
                    .setParameter("Imascota",mascota)
                    .setParameter("Iservicio",servicio)
                    .setParameter("Icuidador",cuidador)
                    .setParameter("Calif",calificacion)
                    .setParameter("Pago",pago)
                    .setParameter("Dir",direccion)
                    .setParameter("Ddescripcion",descripcion);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarSolicitudSP");
            throw e;
        }
    }
}
