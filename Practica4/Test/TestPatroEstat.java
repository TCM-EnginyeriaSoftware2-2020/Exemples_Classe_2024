import CapaDomini.Impressora;
import CapaDomini.PDF;
import CapaDomini.State.IEstat;
import CapaDomini.State.Netejant;
import CapaDomini.State.SensePaper;
import CapaDomini.State.StandBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Random.class)
public class TestPatroEstat {

    private Impressora unaImpressora;

    @BeforeEach
    public void setUp(){
        unaImpressora = new Impressora("test");
    }

   // Crea dues impressores amb 100 pàgines, comprova que es poden canviar d’estats i comprova que l’estat de les dues impressores són independents.
   @Test
   public void testEstatsIndependents(){
       IEstat estatPrimera, estatSegona;

        // agafo una segona impressora i la poso en estat SenseFulls
       Impressora segonaImpressora = new Impressora("segona");
       int fulls = (int) getFieldImpressora(segonaImpressora, "fulls");
       segonaImpressora.imprimirDocument(new PDF(fulls*2));
       estatSegona = (IEstat) getFieldImpressora(segonaImpressora, "estatActual");
       assertInstanceOf(SensePaper.class, estatSegona);

       // comprovo que la primera impressora està en StandBy
       estatPrimera = (IEstat) getFieldImpressora(unaImpressora, "estatActual");
       assertInstanceOf(StandBy.class, estatPrimera);
       unaImpressora.imprimirDocument(new PDF(1));

       // a les comparo, no sé l'estat de la primera però serà diferent a SenseFulls
       estatPrimera = (IEstat) getFieldImpressora(unaImpressora, "estatActual");
       estatSegona = (IEstat) getFieldImpressora(segonaImpressora, "estatActual");
       assertNotEquals(estatPrimera, estatSegona);
   }

    //Comprova que l’estat inicial d’una impressora sigui adequat.
    @Test
    public void testEstatInicial(){
        assertInstanceOf(StandBy.class, IEstat.getEstatInicial());
        assertInstanceOf(StandBy.class, getFieldImpressora(unaImpressora, "estatActual"));
    }

    //Comprova que la impressora funciona correctament quan hi ha suficients pàgines i dona un error quan no hi ha suficient.
    @Test
    public void testSuficientPagines(){
        int fulls = (int) getFieldImpressora(unaImpressora, "fulls");
        int PAQUET_NOU = (int) getFieldImpressora(unaImpressora, "PAQUET_NOU");
        int pages = (int)(Math.random()*PAQUET_NOU) + 1;
        assertEquals(PAQUET_NOU, fulls);
        unaImpressora.imprimirDocument(new PDF(pages));
        fulls = (int) getFieldImpressora(unaImpressora, "fulls");
        assertEquals(PAQUET_NOU-pages, fulls);
    }

    @Test
    public void testInsuficientPagines(){
        int fulls = (int) getFieldImpressora(unaImpressora, "fulls");
        unaImpressora.imprimirDocument(new PDF(fulls + 1));
        assertInstanceOf(SensePaper.class, getFieldImpressora(unaImpressora, "estatActual"));
    }
    //Comprova que la impressora fa neteja de capçals
    @Test
    public void testNeteja(){
        int fulls = (int) getFieldImpressora(unaImpressora, "fulls");
        for( int idx = 0; idx < fulls; idx++)
            unaImpressora.imprimirDocument(new PDF(1));
        assertInstanceOf(Netejant.class, getFieldImpressora(unaImpressora, "estatActual"));
    }
    private Object getFieldImpressora(Impressora laImpressora, String nomAtribut) {
        try {
            Field lAtribut = laImpressora.getClass().getDeclaredField(nomAtribut);
            lAtribut.setAccessible(true);
            return lAtribut.get(laImpressora);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        return null;
    }
}
