package com.digipet.prototype.data;

import com.digipet.prototype.api.dto.CuidadorDTO;
import org.junit.Test;

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
}