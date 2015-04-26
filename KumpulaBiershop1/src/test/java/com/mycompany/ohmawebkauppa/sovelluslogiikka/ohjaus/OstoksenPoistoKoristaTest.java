package com.mycompany.ohmawebkauppa.sovelluslogiikka.ohjaus;

import com.mycompany.webkauppa.model.tietokantayhteydet.TuoteDAO;
import com.mycompany.webkauppa.ohjaus.Komento;
import com.mycompany.webkauppa.ohjaus.KomentotehdasTest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.webkauppa.sovelluslogiikka.*;

public class OstoksenPoistoKoristaTest {

    Varasto varasto = new Varasto(TuoteDAO.inMemory());
    Ostoskori kori;
    long tuoteid = 1;
    KomentotehdasTest komennot;
    Komento ostoksenPoisto;

    @Before
    public void setUp() {
        Tuote tuote = varasto.etsiTuote(tuoteid);
        kori = new Ostoskori();
        kori.lisaaTuote(tuote);
        komennot = new KomentotehdasTest();
    }

    @Test
    public void poistettuTuoteEiEnaaKorissa() {
        ostoksenPoisto = komennot.ostoksenPoistoKorista(kori, tuoteid, varasto);
        ostoksenPoisto.suorita();
    
        assertEquals(0, kori.tuotteitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size());
    }
    
    @Test
    public void tuotteenMaaraKasvaa(){
        int varastossaAluksi = varasto.etsiTuote(tuoteid).getSaldo();
        
        ostoksenPoisto = komennot.ostoksenPoistoKorista(kori, tuoteid, varasto);
        ostoksenPoisto.suorita();
    
        assertEquals(varastossaAluksi+1, varasto.etsiTuote(tuoteid).getSaldo());
    }

}
