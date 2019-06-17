package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.ClienteDTO;
import com.digipet.prototype.api.services.Client;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClienteRepositoryTest {

    @Test
    public void registrarClienteSP() {
        ClienteDTO client = new ClienteDTO();

        client.setPrimerNombre("Casimiro");
        client.setPrimerApellido("Gutierrez");
        client.setSegundoApellido("Alfaro");
        client.setCanton("Alajuela");
        client.setProvincia("Alajuela");
        client.setEmail1("no@correo");
        client.setEmail2("");
        client.setTelefonoMovil("87655432");
        client.setFotoPerfil("nohay.jpg");
        client.setDescripcion("Salu2");
        client.setContrasena("laprogre");
        client.setFechaInscripcion("2019-01-01");


        //ClienteRepository.registrarClienteSP(client); TODO: revisar prueba unitaria si ocurre cambios
    }

    @Test
    public void getAllClients() {
        List<ClienteDTO> clientes = ClienteRepository.getAllClients();
        assertEquals(clientes.get(0).getCanton(),"Santa Ana");
    }

    @Test
    public void getClient() throws Exception {
        try {
            ClienteDTO clienteDTO = ClienteRepository.getClient(2);
            assertEquals(clienteDTO.getCanton(), "Santa Ana");
        } catch (Exception e){
            System.out.println("Excepción capturada en prueba unitaria getClient()");
            throw e;
        }
    }

    @Test
    public void insertarPagoClienteSP() {
        //ClienteRepository.insertarPagoClienteSP(2,"Paypal"); TODO: revisar prueba unitaria si ocurre cambios
    }
}