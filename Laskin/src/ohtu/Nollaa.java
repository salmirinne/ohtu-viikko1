package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int syote;
    private int tulos;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        try {
            syote = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) { 
            syote = 0;
        }
        tulos = sovellus.tulos();
        sovellus.nollaa();
        syotekentta.setText("");
        tuloskentta.setText("0");
    }

    @Override
    public void peru() {
        sovellus.plus(tulos);
        syotekentta.setText(syote != 0 ? String.valueOf(syote) : "");
        tuloskentta.setText(String.valueOf(tulos));
    }

}
