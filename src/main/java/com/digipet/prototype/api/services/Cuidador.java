package com.digipet.prototype.api.services;

import com.digipet.prototype.api.dto.CuidadorDTO;
import com.digipet.prototype.data.CuidadorRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cuidador")
public class Cuidador {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CuidadorDTO get(@PathParam("id") int id){
        CuidadorDTO cuidadorDTO = new CuidadorDTO();

        try{
            cuidadorDTO = CuidadorRepository.getCuidador(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cuidadorDTO;
    }
}
