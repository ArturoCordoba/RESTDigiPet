package com.digipet.prototype.api.authentication;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.security.Principal;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    private static final String REALM = "example";
    private static final String AUTHENTICATION_SCHEME = "Bearer";

    @Override
    public void filter(ContainerRequestContext requestContext) {

        //Obtener la autorizacion del header del request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        //Validar el header de autorizacion
        if (!isTokenBasedAuthentication(authorizationHeader)){
            abortWithUnauthorized(requestContext);
            return;
        }

        //Se extrae el token del header de autorizacion
        final String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

        //Se valida el token
        if(!TokenManager.validateToken(token)){
            abortWithUnauthorized(requestContext);
        }

        //Se crea una nueva instancia de SecurityContext para extraer el nombre de usuario de la peticion
        final SecurityContext currentSecurityContext = requestContext.getSecurityContext();
        requestContext.setSecurityContext(new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
                return () -> TokenManager.decodeToken(token);
            }

            @Override
            public boolean isUserInRole(String s) {
                return true;
            }

            @Override
            public boolean isSecure() {
                return currentSecurityContext.isSecure();
            }

            @Override
            public String getAuthenticationScheme() {
                return AUTHENTICATION_SCHEME;
            }
        });
    }

    /**
     * Metodo que verifica si el header de la autorizacion es valido
     * @param authorizationHeader Header de autorizacion
     * @return True si es valido, false en caso contrario
     */
    private boolean isTokenBasedAuthentication(String authorizationHeader){
        //Verifica si el header de autorizacion es valido
        return authorizationHeader != null && authorizationHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    /**
     * Metodo que se encarga de retornar una respuesta con un codigo de invalido
     * @param requestContext Contexto de la solicitud
     */
    private void abortWithUnauthorized(ContainerRequestContext requestContext){
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE,
                                AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                        .build());
    }
}
