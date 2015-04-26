package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int syote;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
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
        sovellus.miinus(syote);
        syotekentta.setText("");
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

    @Override
    public void peru() {
        sovellus.plus(syote);
        syotekentta.setText(syote != 0 ? String.valueOf(syote) : "");
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

}
