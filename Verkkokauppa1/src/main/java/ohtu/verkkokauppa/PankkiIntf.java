
package ohtu.verkkokauppa;

public interface PankkiIntf {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
