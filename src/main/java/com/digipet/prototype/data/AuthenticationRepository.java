package com.digipet.prototype.data;

import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AuthenticationRepository {
    /**
     * Metodo para validar el correo y contraseña de un usuario que intenta iniciar sesion
     * @param email Email ingresado por el usuario
     * @param password Passsword ingresada por el usuario
     * @return True si las credenciales son correctas, false si son incorrectas
     */
    public static boolean validateCredential(String email, String password){
        try{
            //Se obtiene una conexion con la base de datos
            Session session = HibernateSession.openSession();

            //Se crea el query a ejecutar
            Query query = session.createQuery("FROM UsuarioEntity user WHERE user.email1 = :email1");
            query.setParameter("email1", email);

            //Se obtiene la instancia del usuario
            UsuarioEntity user = (UsuarioEntity) query.getSingleResult();

            //Se valida que el usuario no sea nulo
            if(user != null){
                //Se compara la contraseña ingresada con la almacenada en la base ded atos
                if(user.getContrasena().compareTo(password) == 0)
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
