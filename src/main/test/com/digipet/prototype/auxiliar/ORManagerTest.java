package com.digipet.prototype.auxiliar;

import com.digipet.prototype.orm.ClienteEntity;
import org.junit.Test;

import javax.ws.rs.client.Client;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ORManagerTest {

    @Test
    public void obtenerTabla() {
        ORManager orManager = new ORManager(ClienteEntity.class, null);
        ArrayList<ClienteEntity> list = orManager.obtenerTabla("ClienteEntity");

    }


    @Test
    public void obtenerObjetoPorID() {
        ORManager orManager = new ORManager(ClienteEntity.class, null);
        ClienteEntity clienteEntity = (ClienteEntity) orManager.obtenerObjetoPorID(2);
    }
}