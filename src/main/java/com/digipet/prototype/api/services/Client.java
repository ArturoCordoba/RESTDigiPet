package com.digipet.prototype.api.services;

import com.digipet.prototype.api.authentication.Secured;
import com.digipet.prototype.api.dto.ClienteDTO;
import com.digipet.prototype.data.ClienteRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.ArrayList;

@Path("client")
public class Client {

    /*@GET
    @Produces
    public ArrayList<ClienteDTO> getAll(){
        ArrayList<ClienteDTO> clientList = new ArrayList<ClienteDTO>();
        try{
            clientList = ClienteRepository.getAllClients();
        }
    }*/

    /**
     * Metodo para obtener un cliente especifico
     * @return Objeto ClienteDTO con la informacion obtenida
     */
    @Secured
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO get(@Context SecurityContext securityContext){
        ClienteDTO response = new ClienteDTO();
        try{
            //Se obtiene el identificador del usuario que hizo la solicitud
            Principal principal = securityContext.getUserPrincipal();
            String idString = principal.getName();
            int id = Integer.parseInt(idString);

            //Se realiza la busqueda del cliente
             response = ClienteRepository.getClient(id);

            if(response != null){
                return response;
            }
        } catch (Exception e){

        }
        return response;
    }

    /**
     * Metodo para agregar un nuevo cliente
     * @param client Objeto ClienteDTO con la informacion necesaria para agregar un cliente
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerClient(ClienteDTO client){
        try{
            if(client != null){
                ClienteRepository.registrarClienteSP(client);
                return Response.status(Response.Status.OK).build();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
/*
    @GET
    @Path("/solicitudes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<> obtenerSolicitudes(){

    }*/


    public void obtenerMascotas(){

    }

}
