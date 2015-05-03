
package ohtu.kivipaperisakset.ohjaus;

import ohtu.kivipaperisakset.pelaaja.Pelaaja;

public class KPSPeli {
    
    protected Pelaaja pelaaja1;
    protected Pelaaja pelaaja2;
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        do {
            System.out.print("Pelaajan siirto: ");
            String ekanSiirto = pelaaja1.annaSiirto();
            String tokanSiirto = pelaaja2.annaSiirto();
            System.out.println("Tietokoneen siirto: " + tokanSiirto);
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
    
    protected boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
}
