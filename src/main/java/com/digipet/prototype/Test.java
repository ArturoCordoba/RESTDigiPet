package com.digipet.prototype;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("test")
public class Test {
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList();

    @GET
    @Path("/estudiante/{pos}")
    @Produces(MediaType.APPLICATION_JSON)
    public Estudiante getIt(@PathParam("pos") int pos) {

        return listaEstudiantes.get(pos);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Estudiante get() {
        Estudiante e = new Estudiante("Arturo", 21, "false");
        return e;
    }

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Estudiante> getAll() {
        return listaEstudiantes;
    }



    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarEstudiante(Estudiante estudiante) {

        listaEstudiantes.add(estudiante);

        return Response.status(201).entity(estudiante).build();
    }
}
