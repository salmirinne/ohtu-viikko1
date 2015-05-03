package ohtu.kivipaperisakset.ohjaus;

import ohtu.kivipaperisakset.pelaaja.Tekoaly;
import ohtu.kivipaperisakset.pelaaja.Ihmispelaaja;
import java.util.Scanner;

public class KPSTekoaly extends KPSPeli {

    public KPSTekoaly(Scanner scanner) {
        this.pelaaja1 = new Ihmispelaaja(scanner);
        this.pelaaja2 = new Tekoaly();
    }
    
}