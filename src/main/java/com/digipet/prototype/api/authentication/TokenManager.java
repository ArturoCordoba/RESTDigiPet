package com.digipet.prototype.api.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.ArrayList;

public final class TokenManager {
    private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private static ArrayList<String> tokens = new ArrayList<>();

    private TokenManager(){

    }

    /**
     * Metodo que se encarga de generar el token e insertarlo en la lista de tokens
     * @param username Nombre de usuario
     * @return
     */
    public static String issueToken(String username){
        String token = Jwts.builder().setSubject(username).signWith(key).compact();
        addToken(token);
        return token;
    }

    public static String decodeToken(String token){
        String username = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
        return username;
    }

    public static void addToken(String token){
        tokens.add(token);
    }

    public static boolean validateToken(String token) {
        return tokens.contains(token);
    }

    public static ArrayList getList(){
        return tokens;
    }

}
