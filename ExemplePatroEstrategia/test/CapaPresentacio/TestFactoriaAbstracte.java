
package CapaPresentacio;

import CapaAplicacio.Registre;
import CapaPersistencia.FitxerLocal.ConfiguracioAplicacio2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestFactoriaAbstracte {
	
	static HashSet <Float>  resultatEsperat;
	private final float diners = 80.50f;

	@BeforeEach
	public void TestVenda() {
		resultatEsperat = new HashSet <Float> ();
	}	
	
	@Test
	public void testTotalVendaNula() {
        resultatEsperat.add(diners);//resultat esperat pel descompte null
		try {
			Registre ctl = new Registre ();
	        float totalVenda = ctl.getTotalVenda ();
	        System.out.println ("Import Total de la venda: " + totalVenda);
	        System.out.println(ctl.getDescompte());
	        assertTrue ( resultatEsperat.contains(totalVenda));
		} catch (Exception ex) {
			System.out.println ("ERROR Registre.getTotalVenda(): " + ex.getMessage());
		}		
	}
	
	@Test
	public void testTotalVendaAbsolut() throws Exception {
		ConfiguracioAplicacio2.setProperty("nomFactoriaEstrategiaDescompte",  "CapaAplicacio.FactoriaEstrategiaDescompteVendaAbsolut");
        resultatEsperat.add(diners-2.50f);//resultat esperat pel descompte si supera el llindar
        resultatEsperat.add(diners);//resultat esperat pel descompte si no supera el llindar
		try {
			Registre ctl = new Registre ();
	        float totalVenda = ctl.getTotalVenda ();
	        System.out.println ("Import Total de la venda: " + totalVenda);
	        System.out.println(ctl.getDescompte());        
	        assertTrue (resultatEsperat.contains(totalVenda));
		} catch (Exception ex) {
			System.out.println ("ERROR Registre.getTotalVenda(): " + ex.getMessage());
		}		
	}
	
	@Test
	public void testTotalVendaPercentatge() {
        resultatEsperat.add(diners);//resultat esperat pel descompte descompte 0%
        resultatEsperat.add(diners*0.99f);//resultat esperat pel descompte descompte 1%
        resultatEsperat.add(diners*0.95f);//resultat esperat pel descompte descompte 5%
        resultatEsperat.add(diners*0.90f);//resultat esperat pel descompte descompte 10%
		try {
			Registre ctl = new Registre ();
	        float totalVenda = ctl.getTotalVenda ();
	        System.out.println ("Import Total de la venda: " + totalVenda);
	        System.out.println(ctl.getDescompte());
	        assertTrue (resultatEsperat.contains(totalVenda));
		} catch (Exception ex) {
			System.out.println ("ERROR Registre.getTotalVenda(): " + ex.getMessage());
		}		
	}


}