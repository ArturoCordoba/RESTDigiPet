package com.digipet.prototype.data;

import org.junit.Test;

import java.sql.Date;

public class ClienteRepositoryTest {

    @Test
    public void registrarClienteSP() {
        String dateSTR = "2015-03-31";
        Date date = Date.valueOf(dateSTR);
        ClienteRepository.registrarClienteSP("Gutierrez","Casimiro,",
                "Alfaro","Alajuela","Alajuela","no@correo","","87655432",
                "nohay.jpg","laprogre","Salu2",date);
    }
}