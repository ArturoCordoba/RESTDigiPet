package com.digipet.prototype.api.authentication;

import org.junit.Test;

import static org.junit.Assert.*;

public class TokenManagerTest {

    @Test
    public void issueToken() {

        //Prueba con un correo de gmail
        String username = "arturocv16@gmail.com";

        String token = TokenManager.issueToken(username);

        String decodedToken = TokenManager.decodeToken(token);

        assertEquals(username, decodedToken);

        //Prueba con un correo de yahoo
        String username1 = "jorgegz@yahoo.es";

        String token1 = TokenManager.issueToken(username1);

        String decodedToken1 = TokenManager.decodeToken(token1);

        assertEquals(username1, decodedToken1);

        //Prueba con un correo de outlook
        String username2 = "899285552@outlook.com";

        String token2 = TokenManager.issueToken(username2);

        String decodedToken2 = TokenManager.decodeToken(token2);

        assertEquals(username2, decodedToken2);
    }

    @Test
    public void verifyToken() {
        String username = "arturocv16@gmail.com";

        String token = TokenManager.issueToken(username);

        TokenManager.addToken(token);

        assertEquals(true, TokenManager.validateToken(token));
    }
}