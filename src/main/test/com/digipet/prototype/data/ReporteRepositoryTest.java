package com.digipet.prototype.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReporteRepositoryTest {

    @Test
    public void insertarReporteSP() {
        ReporteRepository.insertarReporteSP(2.5f,2,1,5,3.8f,"Muy jugetón",1);
    }

    @Test
    public void insertarFotoReporteSP() {
        insertarReporteSP();
        ReporteRepository.insertarFotoReporteSP(1,"smiley.pog");
    }
}