import exercici4.ITren;
import exercici4.Rodalies;
import exercici4.AVE;
import exercici4.ViaEuropea;
import exercici4.solucio.Adaptador;
import org.junit.jupiter.api.Test;
import solucio_exercici3.Fantasma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestCase {

    @Test
    public void testPatroEstrategia_Blinky() {
        Fantasma f = new Fantasma(Fantasma.Colors.Blinky,0,0);
        assertTrue(f.moure(new int[] {1,0}));
        assertFalse(f.moure(new int[] {30,0}));
    }

    @Test
    public void testPatroEstrategia_Pinky() {
        Fantasma f = new Fantasma(Fantasma.Colors.Pinky,0,0);
        assertTrue(f.moure(new int[] {0,0}));
        assertFalse(f.moure(new int[] {1,0}));
    }

    @Test
    public void testPatroEstrategia_Inky() {
        Fantasma f = new Fantasma(Fantasma.Colors.Inky,0,0);
        assertTrue(f.moure(new int[] {0,0}));
        assertFalse(f.moure(new int[] {1,0}));
    }

    @Test
    public void testPatroEstrategia_Clyde() {
        Fantasma f = new Fantasma(Fantasma.Colors.Clyde,0,0);
        assertTrue(f.moure(new int[] {0,0}));
        assertFalse(f.moure(new int[] {1,0}));
    }

    @Test
    public void testPatroAdaptador_Rodalies(){
        int seients = 650;
        ITren elTren = new Adaptador( new Rodalies(seients) );
        assertTrue(elTren.comprovaAmplada(ViaEuropea.AMPLADA));
        assertEquals(seients, elTren.getSeients());
        assertEquals(120,elTren.getVelocitatMaxima());

    }

    @Test
    public void testPatroAdaptador_AVE(){
        int seients = 650;
        ITren elTren = new Adaptador( new AVE(seients) );
        assertTrue(elTren.comprovaAmplada(ViaEuropea.AMPLADA));
        assertEquals(seients, elTren.getSeients());
        assertEquals(300,elTren.getVelocitatMaxima());

    }
}
