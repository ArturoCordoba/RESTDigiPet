package com.digipet.prototype.data;

import org.junit.Test;

import java.sql.Date;

public class MascotaRepositoryTest {

    @Test
    public void registrarMascotaSP() {
        String dateSTR = "2015-03-31";
        Date date = Date.valueOf(dateSTR);
        MascotaRepository.registrarMascotaSP(3,"Saborio","Saprissa",37,"XL",
                "Falla todas las oportunidades de gol, pero sigue siendo la vaca sagrada",date);
    }
}