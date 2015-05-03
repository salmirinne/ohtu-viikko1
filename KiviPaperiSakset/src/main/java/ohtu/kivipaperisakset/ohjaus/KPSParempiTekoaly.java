package ohtu.kivipaperisakset.ohjaus;

import ohtu.kivipaperisakset.pelaaja.TekoalyParannettu;
import ohtu.kivipaperisakset.pelaaja.Ihmispelaaja;
import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KPSPeli {

    public KPSParempiTekoaly(Scanner scanner, int muistinkoko) {
        this.pelaaja1 = new Ihmispelaaja(scanner);
        this.pelaaja2 = new TekoalyParannettu(muistinkoko);
    }

}
