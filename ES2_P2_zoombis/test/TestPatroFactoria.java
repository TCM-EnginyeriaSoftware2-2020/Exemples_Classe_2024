

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import CapaDomini.ZoombiCaminant;
import CapaDomini.PatroAdaptador.*;
import CapaAplicacio.ETipusZoombi;
import CapaAplicacio.FactoriaSingleton;

class TestPatroFactoria {

	private static FactoriaSingleton factoriaUnica;
	@BeforeAll
	static void setUpBeforeClass() {
		factoriaUnica = FactoriaSingleton.getInstance();
	}

	@Test
	void test_ZoombiAmagat() {
		int posicio = 5;
		IZoombi zombi = factoriaUnica.getZoombi(ETipusZoombi.ZoombiAmagat, new int[] {posicio} );

		assertNotNull(zombi);
		assertEquals( AdaptadorZoombiAmagat.class , zombi.getClass());
		assertEquals( posicio , zombi.getPosicio());
	}
	
	@Test
	void test_ZoombiCaminant() throws Exception {
		int posicio = 0;
		int velocitat = 2;
		IZoombi zombi = factoriaUnica.getZoombi(ETipusZoombi.ZoombiCaminant, new int[] { posicio, velocitat });

		assertNotNull(zombi);
		assertEquals( AdaptadorZoombiCaminant.class , zombi.getClass());
		assertEquals(posicio, zombi.getPosicio());
		
		Field privateField = AdaptadorZoombiCaminant.class.getDeclaredField("zombi");
		privateField.setAccessible(true);
		ZoombiCaminant zombiOriginal = (ZoombiCaminant) privateField.get(zombi);
		privateField = ZoombiCaminant.class.getDeclaredField("velocitat");
		privateField.setAccessible(true);
		int velocitatOriginal = (int) privateField.get(zombiOriginal);
		
		assertEquals(velocitat, velocitatOriginal);
	}

	@Test
	void test_ZoombiAtacant() {
		int posicio = 5;
		int damage = 2;
		IZoombi zombi = factoriaUnica.getZoombi(ETipusZoombi.ZoombiAtacant, new int[] { posicio, damage });

		assertNotNull(zombi);
		assertEquals( AdaptadorZoombiAtacant.class , zombi.getClass());
		assertEquals(posicio, zombi.getPosicio());
		assertEquals(damage, zombi.getDamage());
	}

}
