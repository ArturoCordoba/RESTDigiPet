package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.ClienteDTO;
import org.junit.Test;

import java.sql.Date;

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


        //ClienteRepository.registrarClienteSP(client);
    }
}