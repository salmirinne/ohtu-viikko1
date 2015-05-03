
package ohtu.kivipaperisakset.pelaaja;

import java.util.Scanner;

public class Ihmispelaaja implements Pelaaja {

    private Scanner scanner;

    public Ihmispelaaja(Scanner scanner) {
        this.scanner = scanner;
    }
    
    @Override
    public String annaSiirto() {
        return scanner.nextLine();
    }

    @Override
    public void asetaSiirto(String siirto) {
    }

}
