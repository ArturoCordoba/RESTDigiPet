package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.MascotaDTO;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MascotaRepositoryTest {

    @Test
    public void registrarMascotaSP() {
        String dateSTR = "2015-03-31";
        Date date = Date.valueOf(dateSTR);
        /*MascotaRepository.registrarMascotaSP(3,"Saborio","Saprissa",37,"XL",
                "Falla todas las oportunidades de gol, pero sigue siendo la vaca sagrada",date);
    */
    }

    @Test
    public void getAllMascotas() {
        List<MascotaDTO> mascotas = MascotaRepository.getAllMascotas();
        assertEquals(mascotas.get(0).getNombre(),"Cookie");
    }

    @Test
    public void getMascota() {
        MascotaDTO result = MascotaRepository.getMascota(1);
        assertEquals(result.getNombre(), "Cookie");
    }

    @Test
    public void insertarFotoMascotaSP() {
        //MascotaRepository.insertarFotoMascotaSP(1,"nueva.jpeg");
    }
}