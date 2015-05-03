
package ohtu.kivipaperisakset.ohjaus;

import java.util.Scanner;

public class Pelitehdas {
    
    public static KPSPeli helppoYksinPeli(Scanner scanner) {
        return new KPSTekoaly(scanner);
    }
    
    public static KPSPeli vaikeaYksinPeli(Scanner scanner, int muistinkoko) {
        return new KPSParempiTekoaly(scanner, muistinkoko);
    }
    
    public static KPSPeli kaksinPeli(Scanner scanner) {
        return new KPSPelaajaVsPelaaja(scanner);
    }
    
}
