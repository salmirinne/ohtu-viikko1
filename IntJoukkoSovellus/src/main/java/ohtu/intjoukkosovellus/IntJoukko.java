
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,    // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;                    // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;                         // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;                    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luvut = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }
 
    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasiteetin on oltava positiivinen");
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IllegalArgumentException("Kapasiteetin on oltava positiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IllegalArgumentException("Kasvatuskoon on oltava positiivinen");
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku))
            return false;
        if (alkioidenLkm == luvut.length) {
            int[] uudet = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(luvut, uudet);
            luvut = uudet;
        }
        luvut[alkioidenLkm++] = luku;
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                if (i == luvut.length - 1) {
                    luvut[i] = 0;
                } else {
                    System.arraycopy(luvut, i + 1, luvut, i, luvut.length - i - 1);
                }
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }
    
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }
    @Override
    public String toString() {
        int[] taulukko = new int[alkioidenLkm];
        System.arraycopy(luvut, 0, taulukko, 0, alkioidenLkm);
        return Arrays.toString(taulukko).replaceAll("\\[", "{").replaceAll("\\]", "}");
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(luvut, 0, taulu, 0, taulu.length);
        return taulu;
    }
    
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko result = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            result.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            result.lisaa(bTaulu[i]);
        }
        return result;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko result = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    result.lisaa(bTaulu[j]);
                }
            }
        }
        return result;
    }
    
    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko result = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            result.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            result.poista(i);
        }
        return result;
    }
        
}