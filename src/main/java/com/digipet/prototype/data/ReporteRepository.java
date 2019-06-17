package com.digipet.prototype.data;

import com.digipet.prototype.orm.FotoXReporteEntity;
import com.digipet.prototype.orm.ReporteEntity;
import org.hibernate.Session;

public class ReporteRepository {

    /**
     * Método que llama al Store Procedure de INSERTAR_REPORTE
     * @param duracion duración de la caminata
     * @param caca cantidad de veces que hizo del 'dos'
     * @param orines cantidad de veces que hizo del 'uno'
     * @param juegos cantidad de veces que jugó
     * @param distancia distancia recorrida durante la caminata
     * @param detalles detalles de la caminata
     * @param solicitud solicitud de la caminata
     */
    public static void insertarReporteSP(float duracion, int caca, int orines, int juegos, float distancia,
                                           String detalles, int solicitud){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_REPORTE(:Duration,:Caca,:Orines,:Juegos,:Distance,:Details," +
                            ":Isolicitud)")
                    .addEntity(ReporteEntity.class)
                    .setParameter("Duration",duracion)
                    .setParameter("Caca",caca)
                    .setParameter("Orines",orines)
                    .setParameter("Juegos",juegos)
                    .setParameter("Distance",distancia)
                    .setParameter("Details",detalles)
                    .setParameter("Isolicitud",solicitud);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarReporteSP");
            throw e;
        }
    }

    /**
     * Método que llama al Store Procedure de INSERTAR_FOTO_REPORTE
     * @param reporte reporte al cual asignar las fotos
     * @param fotoReporte fotos a asginar
     */
    public static void insertarFotoReporteSP(int reporte, String fotoReporte){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_FOTO_REPORTE(:Ireporte,:Foto_reporte)")
                    .addEntity(FotoXReporteEntity.class)
                    .setParameter("Ireporte",reporte)
                    .setParameter("Foto_reporte",fotoReporte);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarFotoReporteSP");
            throw e;
        }
    }
}
