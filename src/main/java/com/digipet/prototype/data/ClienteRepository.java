package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.ClienteDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.ClienteEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;

public class ClienteRepository {

    public static ArrayList<ClienteEntity> getAllClients() {
        ArrayList<ClienteEntity> data;

        Session session = HibernateSession.openSession();

        try {
            Query query = session.createQuery("FROM " + "ClienteEntity");
            data = (ArrayList<ClienteEntity>) query.getResultList();

        } catch (Exception exception){
            System.out.println("Error no identificado");
            throw exception;
        }

        return data;
    }

    public static ClienteDTO getClient(int id) throws Exception{
        //Se obtiene el cliente respectivo
        ClienteEntity client = ORManager.obtenerObjetoPorID(id,ClienteEntity.class);

        UsuarioEntity user = ORManager.obtenerObjetoPorID(id,UsuarioEntity.class);

        if(client != null && user != null){
            ClienteDTO clienteDTO = convertToDTO(user, client);
            return clienteDTO;
        } else {
            throw new Exception();
        }
    }

    private static ClienteDTO convertToDTO(UsuarioEntity user, ClienteEntity clienteEntity){
        ClienteDTO client = new ClienteDTO();
        client.setIdUsuario(user.getIdUsuario());
        client.setPrimerNombre(user.getPrimerNombre());
        client.setPrimerApellido(user.getPrimerApellido());
        client.setSegundoApellido(user.getSegundoApellido());
        client.setEmail1(user.getEmail1());
        client.setContrasena(user.getContrasena());
        client.setFotoPerfil(user.getFotoPerfil());
        client.setId_rol(user.getRol().getIdRol());
        client.setId_estado(user.getEstado().getIdEstado());
        client.setTelefonoMovil(clienteEntity.getTelefonoMovil());
        client.setCanton(clienteEntity.getCanton());
        client.setEmail2(clienteEntity.getEmail2());
        client.setDescripcion(clienteEntity.getDescripcion());
        client.setFechaInscripcion(clienteEntity.getFechaInscripcion().toString());
        client.setId_provincia(clienteEntity.getProvincia().getIdProvincia());

        return client;
    }

    /**
     * Método que llama al Store Procedure de REGISTRAR_CLIENTE
     * @param nombre nombre del usuario
     * @param primerApellido primer apellido del usuario
     * @param segundoApellido segundo apellido del usuario
     * @param provincia provincia de localización deñ cliente
     * @param canton cantón de localización del cliente
     * @param correo1 correo del usuario
     * @param correo2 correo del cliente (puede estar vacío)
     * @param telefono teléfono del cliente
     * @param foto foto del usuario
     * @param contrasena contraseña del usuario
     * @param descripcion descripción del cliente
     * @param fecha fecha de inscripción
     */
    public static void registrarClienteSP(String nombre, String primerApellido, String segundoApellido,
                                          String provincia, String canton, String correo1, String correo2,
                                          String telefono, String foto, String contrasena, String descripcion,
                                          Date fecha){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            if (correo2==null) correo2 = "";

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL REGISTRAR_CLIENTE(:Pnombre,:Papellido,:Sapellido,:Iprovincia,:Ccanton," +
                            ":Correo1,:Correo2,:Telefono,:Foto,:Contrasena,:Ddescripcion,:Fecha)")
                    .addEntity(UsuarioEntity.class)
                    .addEntity(ClienteEntity.class)
                    .setParameter("Pnombre",nombre)
                    .setParameter("Papellido",primerApellido)
                    .setParameter("Sapellido",segundoApellido)
                    .setParameter("Iprovincia",provincia)
                    .setParameter("Ccanton",canton)
                    .setParameter("Correo1",correo1)
                    .setParameter("Correo2",correo2)
                    .setParameter("Telefono",telefono)
                    .setParameter("Foto",foto)
                    .setParameter("Contrasena", contrasena)
                    .setParameter("Ddescripcion",descripcion)
                    .setParameter("Fecha",fecha);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de registrarClienteSP");
            throw e;
        }
    }
}
