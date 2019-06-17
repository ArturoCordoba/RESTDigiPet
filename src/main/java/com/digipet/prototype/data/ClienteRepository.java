package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.ClienteDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.ClienteEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;

public class ClienteRepository {

    /**
     * Método que obtiene la la tabla de clientes
     * @return ArrayList de clientes
     */
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

    /**
     * Método que retorna un cliente según su id
     * @param id del cliente
     * @return cliente a quien pertenece el id
     * @throws Exception Si el cliente o usuario son nulos
     */
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

    /**
     * Método que parsea un cliente/usuario a un cliente completo
     * @param user usuario de la base
     * @param clienteEntity cliente de la base relacionado al usuario
     * @return ClienteDTO completo
     */
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
        client.setProvincia(clienteEntity.getProvincia().getNombre());

        return client;
    }

    /**
     * Método que llama al Store Procedure de REGISTRAR_CLIENTE
     * @param cliente Objeto DTO que contiene los datos del cliente que se desea registrar
     */
    public static void registrarClienteSP(ClienteDTO cliente){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            Date date = new Date();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL REGISTRAR_CLIENTE(:Pnombre,:Papellido,:Sapellido,:Iprovincia,:Ccanton," +
                            ":Correo1,:Correo2,:Telefono,:Foto,:Contrasena,:Ddescripcion,:Fecha)")
                    .addEntity(UsuarioEntity.class)
                    .addEntity(ClienteEntity.class)
                    .setParameter("Pnombre",cliente.getPrimerNombre())
                    .setParameter("Papellido",cliente.getPrimerApellido())
                    .setParameter("Sapellido",cliente.getSegundoApellido())
                    .setParameter("Iprovincia",cliente.getProvincia())
                    .setParameter("Ccanton",cliente.getCanton())
                    .setParameter("Correo1",cliente.getEmail1())
                    .setParameter("Correo2",cliente.getEmail2())
                    .setParameter("Telefono",cliente.getTelefonoMovil())
                    .setParameter("Foto",cliente.getFotoPerfil())
                    .setParameter("Contrasena", cliente.getContrasena())
                    .setParameter("Ddescripcion",cliente.getDescripcion())
                    .setParameter("Fecha",date);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de registrarClienteSP");
            e.printStackTrace();
            throw e;
        }
    }
}
