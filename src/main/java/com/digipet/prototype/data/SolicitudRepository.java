package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.SolicitudDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.SolicitudEntity;
import org.hibernate.Session;

import java.sql.Date;
import java.sql.Timestamp;

public class SolicitudRepository {

    /**
     * Metodo para obtener una solicitud especifica
     * @param id Identificador de la solicitud
     * @return Objeto SolicitudDTO con la informacion
     * @throws Exception
     */
    public static SolicitudDTO getSolicitud(int id) throws Exception{
        //Se obtiene la solicitud respectiva
        SolicitudEntity solicitudEntity = ORManager.obtenerObjetoPorID(id,SolicitudEntity.class);

        if(solicitudEntity != null){
            SolicitudDTO solicitudDTO = convertToDTO(solicitudEntity);
            return solicitudDTO;
        } else {
            throw new Exception();
        }
    }

    /**
     * Metodo para convertir un objeto SolicitudEntity a uno SolicitudDTO
     * @param solicitudEntity Instancia que se desea convertir
     * @return Objeto DTO generado
     */
    private static SolicitudDTO convertToDTO(SolicitudEntity solicitudEntity) {
        //Se crean los objetos
        SolicitudDTO solicitudDTO = new SolicitudDTO();

        //Se ingresan los atributos
        solicitudDTO.setHoraInicio(solicitudEntity.getHoraInicio().toString());
        solicitudDTO.setHoraFinal(solicitudEntity.getHoraFinal().toString());
        solicitudDTO.setDuracion(solicitudEntity.getDuracion());
        solicitudDTO.setPrecio(solicitudEntity.getPrecioUnitario());
        solicitudDTO.setIdMascota(solicitudEntity.getMascota().getIdMascota());
        solicitudDTO.setIdServicio(solicitudEntity.getIdSolicitud());

        return solicitudDTO;
    }

    /**
     * Método que llama al Store Procedure de INSERTAR_SOLICITUD
     * @param horaInicio hora de inicio de la solicitud
     * @param horaFinal hora final de la solicitud
     * @param duracion duración de la solicitud
     * @param precio precio total de la solicitud
     * @param cliente cliente que pide la solicitud
     * @param mascota mascota de la solicitud
     * @param servicio tipo de servicio

     */
    public static void insertarSolicitudSP(Timestamp horaInicio, Timestamp horaFinal, float duracion,
                                           float precio, int cliente, int mascota, int servicio){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_SOLICITUD(:FHora_inicio,:FHora_final,:Dduracion,:Esolicitud,:Precio,:Icliente," +
                            ":Imascota,:Iservicio)")
                    .addEntity(SolicitudEntity.class)
                    .setParameter("FHora_inicio", horaInicio)
                    .setParameter("FHora_final",horaFinal)
                    .setParameter("Dduracion",duracion)
                    .setParameter("Esolicitud","Pendiente")
                    .setParameter("Precio",precio)
                    .setParameter("Icliente",cliente)
                    .setParameter("Imascota",mascota)
                    .setParameter("Iservicio",servicio);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarSolicitudSP");
            throw e;
        }
    }
}
