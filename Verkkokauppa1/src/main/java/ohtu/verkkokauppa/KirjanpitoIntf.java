
package ohtu.verkkokauppa;

import java.util.List;

public interface KirjanpitoIntf {
    List<String> getTapahtumat();
    void lisaaTapahtuma(String tapahtuma);
}
