package com.digipet.prototype.api.services;

import com.digipet.prototype.api.authentication.Secured;
import com.digipet.prototype.api.dto.MascotaDTO;
import com.digipet.prototype.data.MascotaRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.Date;

@Path("mascota")
public class Mascota {

    /**
     * Metodo para obtener una mascota de la base de datos
     * @param id Identificador de la mascota
     * @return Objeto MascotaDTO con la informacion de la mascota
     */
    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public MascotaDTO get(@PathParam("id") int id){
        MascotaDTO mascotaDTO = new MascotaDTO();

        try{
            mascotaDTO = MascotaRepository.getMascota(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mascotaDTO;
    }

    /**
     * Metodo para registrar una mascota
     * @param securityContext
     * @param mascota
     * @return
     */
    @Secured
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarMascota(@Context SecurityContext securityContext, MascotaDTO mascota){
        try{
            if(mascota != null){
                //Se obtiene el identificador del usuario que esta realizando
                //la solicitud
                Principal principal = securityContext.getUserPrincipal();
                String stringID = principal.getName();
                int id = Integer.valueOf(stringID);

                //Se obtiene la fecha en la que se realiza la solicitud
                Date date = new Date();

                //Se realiza el proceso de registro
                MascotaRepository.registrarMascotaSP(id,
                        mascota.getNombre(),
                        mascota.getRaza(),
                        mascota.getEdad(),
                        mascota.getTamano(),
                        mascota.getDescripcion(),
                        date);

                return Response.status(Response.Status.OK).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
