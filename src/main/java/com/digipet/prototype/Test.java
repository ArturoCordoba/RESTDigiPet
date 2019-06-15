package com.digipet.prototype;

import com.digipet.prototype.api.authentication.Role;
import com.digipet.prototype.api.authentication.Secured;
import com.digipet.prototype.api.authentication.TokenManager;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;
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

    @Secured//({Role.ADMINISTRATOR})
    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Estudiante> getAll(@Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();

        System.out.println(username);

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

    @POST
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToken(){
        String token = TokenManager.issueToken("admin");

        TokenManager.addToken(token);

        return Response.status(Response.Status.OK).entity(token).build();

    }
}
