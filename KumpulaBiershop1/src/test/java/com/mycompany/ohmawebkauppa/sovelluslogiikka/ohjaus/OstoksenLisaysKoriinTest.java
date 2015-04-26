package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAO;
import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.ohjaus.KomentotehdasTest;
import com.mycompany.webkauppa.sovelluslogiikka.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OstoksenLisaysKoriinTest {
    Varasto varasto = new Varasto(TuoteDAO.inMemory());
    Ostoskori kori;    
    long tuoteid = 1;
    Tuote tuote;
    KomentotehdasTest komennot;
    Komento ostoksenLisays;
    
    @Before
    public void setUp() {
        tuote = varasto.etsiTuote(tuoteid);     
        if ( tuote.getSaldo()==0 ) {
            tuote.setSaldo(1);
        } 
        kori = new Ostoskori();   
        komennot = new KomentotehdasTest();
    }
    
    @Test
    public void koriSisaltaaLisatynTuotteen() {
        ostoksenLisays = komennot.ostoksenLisaysKoriin(kori, tuoteid, varasto);
        ostoksenLisays.suorita();
    
        assertEquals(1, kori.tuotteitaKorissa());
        assertEquals(tuote.getHinta(), kori.hinta());
        assertEquals(tuote.getNimi(), kori.ostokset().get(0).tuotteenNimi());
    }
    
    @Test
    public void tuotteenMaaraVahentyy(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
        
        ostoksenLisays = komennot.ostoksenLisaysKoriin(kori, tuoteid, varasto);
        ostoksenLisays.suorita();
    
        assertEquals(varastossaAluksi-1, varasto.etsiTuote(tuoteid).getSaldo());
    }
    
    @Test
    public void josTuotteenVarastosaldoNollaEiTuotettaLaitetaOstoskoriin() {
        varasto.etsiTuote(tuoteid).setSaldo(0);
        
        ostoksenLisays = komennot.ostoksenLisaysKoriin(kori, tuoteid, varasto);
        ostoksenLisays.suorita();
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size() );
    }
}
