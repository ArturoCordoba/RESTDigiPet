package com.digipet.prototype.data;


import com.digipet.prototype.api.dto.ClientDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.ClienteEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

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

    public static ClientDTO getClient(int id) throws Exception{
        //Se obtiene el cliente respectivo
        ORManager orManager = new ORManager(ClienteEntity.class, null);
        ClienteEntity client = (ClienteEntity) orManager.obtenerObjetoPorID(id);

        ORManager orManager1 = new ORManager(UsuarioEntity.class, null);
        UsuarioEntity user = (UsuarioEntity) orManager1.obtenerObjetoPorID(id);

        if(client != null && user != null){
            ClientDTO clientDTO = convertToDTO(user, client);
            return clientDTO;
        } else {
            throw new Exception();
        }
    }

    private static ClientDTO convertToDTO(UsuarioEntity user, ClienteEntity clienteEntity){
        ClientDTO client = new ClientDTO();
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
}
