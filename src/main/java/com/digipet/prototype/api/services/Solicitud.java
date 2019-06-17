package com.digipet.prototype.api.services;

import com.digipet.prototype.api.authentication.Secured;
import com.digipet.prototype.api.dto.SolicitudDTO;
import com.digipet.prototype.data.SolicitudRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.sql.Timestamp;

@Path("solicitud")
public class Solicitud {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SolicitudDTO get(@PathParam("id") int id){
        SolicitudDTO solicitud = new SolicitudDTO();

        try{
            solicitud = SolicitudRepository.getSolicitud(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return solicitud;
    }

    @Secured
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarSolicitud(@Context SecurityContext securityContext, SolicitudDTO solicitudDTO){
        try{
            if(solicitudDTO != null){
                //Se obtiene el identificador del usuario que esta realizando la solicitud
                Principal principal = securityContext.getUserPrincipal();
                String stringID = principal.getName();
                int idCliente = Integer.valueOf(stringID);

                Timestamp horaInicio = Timestamp.valueOf(solicitudDTO.getHoraInicio());
                Timestamp horaFinal =  Timestamp.valueOf(solicitudDTO.getHoraFinal());

                SolicitudRepository.insertarSolicitudSP(
                        horaInicio,
                        horaFinal,
                        solicitudDTO.getDuracion(),
                        solicitudDTO.getPrecio(),
                        idCliente,
                        solicitudDTO.getIdMascota(),
                        solicitudDTO.getIdServicio()
                );

                return Response.status(Response.Status.CREATED).build();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
