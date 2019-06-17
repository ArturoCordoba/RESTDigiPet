package com.digipet.prototype.api.authentication;

import com.digipet.prototype.api.dto.Credentials;
import com.digipet.prototype.data.AuthenticationRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authenticateuser")
public class AuthenticationEndpoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials){
        String username = credentials.getEmail();
        String password = credentials.getPassword();

        try {
            //Se intenta autenticar al usuario con las credenciales proveidas
            authenticate(username, password);

            //Se obtiene el identificador del usuario
            int id = AuthenticationRepository.getIdUser(username);

            //Se crea un token para el usuario recibido
            String token = TokenManager.issueToken(Integer.toString(id));

            return Response.ok().entity(jsonToken(token)).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }


    private void authenticate(String username, String password) throws Exception {
            if (!AuthenticationRepository.validateCredential(username, password)) {
                throw new Exception("Invalid authentication");
            }
    }

    private String jsonToken(String token){
        return  "{\"data\": {\"token\":\"" + token + "\"}}";
    }
}
