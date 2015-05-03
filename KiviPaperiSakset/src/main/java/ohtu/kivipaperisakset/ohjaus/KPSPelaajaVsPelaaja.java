package ohtu.kivipaperisakset.ohjaus;

import ohtu.kivipaperisakset.pelaaja.Ihmispelaaja;
import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSPeli {

    public KPSPelaajaVsPelaaja(Scanner scanner) {
        this.pelaaja1 = new Ihmispelaaja(scanner);
        this.pelaaja2 = new Ihmispelaaja(scanner);
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        do {
            System.out.print("Pelaaja 1 siirto: ");
            String ekanSiirto = pelaaja1.annaSiirto();
            System.out.print("Pelaaja 2 siirto: ");
            String tokanSiirto = pelaaja2.annaSiirto();
            if (!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                break;
            }
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            pelaaja1.asetaSiirto(tokanSiirto);
            pelaaja2.asetaSiirto(ekanSiirto);
        } while(true);
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
}