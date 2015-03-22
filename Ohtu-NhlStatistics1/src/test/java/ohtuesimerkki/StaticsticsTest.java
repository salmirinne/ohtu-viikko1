
package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class StaticsticsTest {
    
    Statistics stats;
    
    Reader readerStub = new Reader() {
        
        public List<Player> getPlayers() {
            List<Player> players = new ArrayList<Player>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            return players;
        }
        
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void haeNimellaCrosby() {
        assertEquals(null, stats.search("Crosby"));
    }
    
    @Test
    public void haeNimellaKurri() {
        assertEquals(new Player("Kurri", "EDM", 37, 53).toString(), stats.search("Kurri").toString());
    }
    
    @Test
    public void haeJoukkueEDM() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void haeJoukkuePIT() {
        assertEquals(1, stats.team("PIT").size());
    }
    
    @Test
    public void haeJoukkueASD() {
        assertEquals(0, stats.team("ASD").size());
    }
    
    @Test
    public void haeParasPistemies() {
        assertEquals(new Player("Gretzky", "EDM", 35, 89).toString(), 
                stats.topScorers(3).get(0).toString());
    }
    
    @Test
    public void haePistemiehet() {
        assertEquals(5, stats.topScorers(4).size());
    }
    
    @Test
    public void haePistemiehetNegatiivisellaArvolla() {
        assertEquals(0, stats.topScorers(-1).size());
    }

}