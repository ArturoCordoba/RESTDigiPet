package com.digipet.prototype.api.services;

import com.digipet.prototype.api.dto.ClientDTO;
import com.digipet.prototype.data.ClientRepository;
import com.digipet.prototype.orm.ClienteEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("client")
public class Client {

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClientDTO get(@PathParam("id") int id){
        ClientDTO response = new ClientDTO();
        try{
             response = ClientRepository.getClient(id);

            if(response != null){
                return response;
            }
        } catch (Exception e){

        }
        return response;
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
