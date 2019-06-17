package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.CuidadorDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CuidadorRepositoryTest {

    @Test
    public void getCuidador() {
        try{
            CuidadorDTO cuidadorDTO = CuidadorRepository.getCuidador(4);
            System.out.println(cuidadorDTO.getCanton());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void getAllCuidadores() {
        /*List<CuidadorDTO> cuidadorDTOList = CuidadorRepository.getAllCuidadores();
        assertEquals(cuidadorDTOList.get(0).getCarne(),"03639362");*/
    }

    @Test
    public void registrarCuidadorSP() {
        List<String> disponibilidad = new ArrayList<>();
        List<String> provincias = new ArrayList<>();
        List<String> solicitudes = new ArrayList<>();

        CuidadorDTO cuidador = new CuidadorDTO(0,"Rodrigo","Pereira","Mora","otro@mail","nocontra","esta.foto",
                3,0,"666666","878787","Alajuela",false,"","Rodrigo es de prueba :)", "2017-01-01", "Universidad de Costa Rica",
                disponibilidad, provincias, solicitudes, "Alajuela");
        //CuidadorRepository.registrarCuidadorSP(cuidador); TODO: revisar prueba unitaria si ocurre cambios
    }

    @Test
    public void insertarBadgeCuidadorSP() {
        //CuidadorRepository.insertarBadgeCuidadorSP(4,1);
    }

    @Test
    public void insertarProvinciaCuidadorSP() {
    }
}