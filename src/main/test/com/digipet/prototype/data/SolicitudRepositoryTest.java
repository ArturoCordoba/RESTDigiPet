package com.digipet.prototype.data;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class SolicitudRepositoryTest {

    @Test
    public void insertarSolicitudSP() {
        Timestamp timestampI = Timestamp.valueOf("2019-06-18 13:00:00");
        Timestamp timestampF = Timestamp.valueOf("2019-06-18 15:00:00");
        SolicitudRepository.insertarSolicitudSP(timestampI,timestampF,2f,120f,3,2,1);
    }
}