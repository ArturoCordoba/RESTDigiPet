package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.ClienteDTO;
import com.digipet.prototype.auxiliar.ORManager;
import com.digipet.prototype.orm.ClienteEntity;
import com.digipet.prototype.orm.PagoXClienteEntity;
import com.digipet.prototype.orm.UsuarioEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteRepository {

    /**
     * Método que obtiene la la tabla de clientes
     * @return ArrayList de clientes
     */
    public static List getAllClients() {
        List<ClienteDTO> data = null;
        List clientes;

        Session session = HibernateSession.openSession();

        try {
            Query query = session.createQuery("FROM " + "ClienteEntity");
            clientes = query.getResultList();

            for (Object cliente : clientes) {
                ClienteEntity clienteEntity = (ClienteEntity) cliente;
                UsuarioEntity usuarioEntity = ORManager.obtenerObjetoPorID(clienteEntity.getIdCliente(), UsuarioEntity.class);
                data.add(convertToDTO(usuarioEntity, clienteEntity));
            }

        } catch (NullPointerException nullptr){
            System.out.println("Error de puntero al convertir en DTO");
            throw nullptr;
        } catch (Exception exception){
            System.out.println("Error no identificado en getAllClients");
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
        ClienteEntity clienteEntity = ORManager.obtenerObjetoPorID(id,ClienteEntity.class);

        UsuarioEntity usuarioEntity = ORManager.obtenerObjetoPorID(id,UsuarioEntity.class);

        if(clienteEntity != null && usuarioEntity != null){
            ClienteDTO clienteDTO = convertToDTO(usuarioEntity, clienteEntity);
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
     * @param correo1 correo primario del cliente
     * @param correo2 correo secundario del cliente (puede estar vacío)
     * @param telefono teléfono del cliente
     * @param foto foto de perfil del usuario
     * @param contrasena contraseña del usuario
     * @param descripcion descripción del cliente
     * @param fecha fecha de inscripción del cliente
     */
    public static void registrarClienteSP(String nombre, String primerApellido, String segundoApellido,
                                          String provincia, String canton, String correo1, String correo2,
                                          String telefono, String foto, String contrasena, String descripcion,
                                          Date fecha){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            if (correo2 == null) correo2 = "";

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

    /**
     * Método que llama al Store Procedure de INSERTAR_PAGO_CLIENTE
     * @param cliente cliente a asignar el pago
     * @param pago pago a asignar
     */
    public static void insertarPagoClienteSP(int cliente, String pago){
        try {
            Session session = com.digipet.prototype.data.HibernateSession.openSession();

            session.beginTransaction();
            org.hibernate.query.Query query = session.createSQLQuery(
                    "CALL INSERTAR_PAGO_CLIENTE(:Icliente,:Pago)")
                    .addEntity(PagoXClienteEntity.class)
                    .setParameter("Icliente",cliente)
                    .setParameter("Pago",pago);

            query.executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e){
            System.out.println("Durante el procesamiento de insertarPagoClienteSP");
            throw e;
        }
    }
}
