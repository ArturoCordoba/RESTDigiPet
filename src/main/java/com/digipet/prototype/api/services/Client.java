package com.digipet.prototype.api.services;

import com.digipet.prototype.api.dto.ClienteDTO;
import com.digipet.prototype.data.ClienteRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("client")
public class Client {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClienteDTO get(@PathParam("id") int id){
        ClienteDTO response = new ClienteDTO();
        try{
             response = ClienteRepository.getClient(id);

            if(response != null){
                return response;
            }
        } catch (Exception e){

        }
        return response;
    }

    /*@POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerClient(ClienteDTO client){

    }*/
/*
    @GET
    @Path("/solicitudes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<> obtenerSolicitudes(){

    }*/


    public void obtenerMascotas(){

    }

}
