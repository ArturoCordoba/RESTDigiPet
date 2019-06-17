package com.digipet.prototype.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class DenunciaRepositoryTest {

    @Test
    public void insertarDenunciaSP() {
        DenunciaRepository.insertarDenunciaSP(2,8,"Huele a mi perro de manera extraña");
    }
}