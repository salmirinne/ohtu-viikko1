package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.ohjaus.Pelitehdas;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                Pelitehdas.kaksinPeli(scanner).pelaa();
            } else if (vastaus.endsWith("b")) {
                Pelitehdas.helppoYksinPeli(scanner).pelaa();
            } else if (vastaus.endsWith("c")) {
                Pelitehdas.vaikeaYksinPeli(scanner, 20).pelaa();
            } else {
                break;
            }

        }

    }
}
