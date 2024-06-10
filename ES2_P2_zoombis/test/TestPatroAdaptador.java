import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import CapaAplicacio.ETipusZoombi;
import CapaAplicacio.FactoriaSingleton;
import CapaDomini.Personatge;
import CapaDomini.PatroAdaptador.AdaptadorZoombiAmagat;
import CapaDomini.PatroAdaptador.AdaptadorZoombiAtacant;
import CapaDomini.PatroAdaptador.AdaptadorZoombiCaminant;
import CapaDomini.PatroAdaptador.IZoombi;

class TestPatroAdaptador {

	private Personatge personatge;
	private static FactoriaSingleton factoriaUnica;
	
	@BeforeAll
	static void setUpBeforeClass() {
		factoriaUnica = FactoriaSingleton.getInstance();
	}
	
	@BeforeEach
	void setUp() {
		personatge = new Personatge( 5 );
	}
	

	@Test
	void test_ZoombiAmagat() {
		AdaptadorZoombiAmagat zombi = new AdaptadorZoombiAmagat( new int[] { personatge.getPosicio() });
		this.zoombiAmagat(zombi);
	}
	
	@Test
	void test_AdaptadorZoombiAmagat() {
		IZoombi zombi = factoriaUnica.getZoombi(ETipusZoombi.ZoombiAmagat, new int[] {personatge.getPosicio() });

		assertNotNull(zombi);
		assertEquals( AdaptadorZoombiAmagat.class , zombi.getClass());
		this.zoombiAmagat((AdaptadorZoombiAmagat) zombi);
	}
	
	private void zoombiAmagat(AdaptadorZoombiAmagat zombi) {
		assertFalse( zombi.moure( - personatge.getPosicio()));
		assertTrue( zombi.moure(personatge.getPosicio()));
		assertEquals(personatge.getPosicio(), zombi.getPosicio());
		assertEquals(0, zombi.getDamage());
		assertFalse( zombi.isVisible() );
	}
	
	@Test
	void test_ZoombiCaminant(){
		int posicio = 0;
		int velocitat = 2;
		AdaptadorZoombiCaminant zombi = new AdaptadorZoombiCaminant( new int[] { posicio, velocitat });
		this.zoombiCaminant(posicio, velocitat, zombi);
	}
	
	@Test
	void test_AdaptadorZoombiCaminant() {
		int posicio = 0;
		int velocitat = 2;
		IZoombi zombi = factoriaUnica.getZoombi(ETipusZoombi.ZoombiCaminant, new int[] { posicio, velocitat });

		assertNotNull(zombi);
		assertEquals( AdaptadorZoombiCaminant.class , zombi.getClass());
		this.zoombiCaminant(posicio, velocitat, (AdaptadorZoombiCaminant) zombi);
	}
	
	private void zoombiCaminant(int posicio, int velocitat, AdaptadorZoombiCaminant zombi) {
		assertEquals(posicio, zombi.getPosicio());
		assertEquals(0, zombi.getDamage());
		assertTrue( zombi.isVisible() );
		// moure
		posicio += velocitat;
		assertFalse( zombi.moure(personatge.getPosicio()));
		assertEquals(posicio, zombi.getPosicio());
		// moure
		posicio += velocitat;
		assertFalse( zombi.moure(personatge.getPosicio()));
		assertEquals(posicio, zombi.getPosicio());
		// moure i atrapa
		assertTrue( zombi.moure(personatge.getPosicio()));
		assertEquals(personatge.getPosicio(), zombi.getPosicio());
	}

	@Test
	void test_ZoombiAtacant(){
		int posicio = personatge.getPosicio();
		int damage = 2;
		AdaptadorZoombiAtacant zombi = new AdaptadorZoombiAtacant( new int[] { posicio, damage });
		this.zoombiAtacant(posicio, damage, zombi);
	}
	
	@Test
	void test_AdaptadorZoombiAtacant() {
		int posicio = 5;
		int damage = 2;
		IZoombi zombi = factoriaUnica.getZoombi(ETipusZoombi.ZoombiAtacant, new int[] { posicio, damage });

		assertNotNull(zombi);
		assertEquals( AdaptadorZoombiAtacant.class , zombi.getClass());
		this.zoombiAtacant(posicio, damage, (AdaptadorZoombiAtacant) zombi);
	}
	
	private void zoombiAtacant( int posicio, int damage, AdaptadorZoombiAtacant zombi) {
		assertEquals(posicio, zombi.getPosicio());
		assertEquals(damage, zombi.getDamage());
		assertTrue( zombi.isVisible() );
		assertFalse( zombi.moure( - personatge.getPosicio()));
		assertTrue( zombi.moure(personatge.getPosicio()));
	}
}
