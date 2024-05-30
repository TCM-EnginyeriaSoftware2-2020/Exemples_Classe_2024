
package CapaPresentacio;


import CapaDomini.Venda;
import CapaDomini.EstrategiaDescompteVenda.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestEstrategies {
	
	private static Venda vendaFicticia;
	private IEstrategiaDescompteVenda Estrategia;
	private static float DINERS;
	private final float ERRORACCEPTAT = 0.001f;// 80.501 - 80.499
	
	@BeforeAll
	public static void TestVenda() {
		vendaFicticia = new Venda();
		DINERS = vendaFicticia.getTotalAbansDte(); //80.50
	}	
	
	@Test
	public void testGetTotalNula() {
		try {
			Estrategia = new EstrategiaDescompteVendaNula( "Nula" );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda Nula: " + totalVenda);
	        assertEquals (totalVenda, DINERS, ERRORACCEPTAT);
		} catch (Exception ex) {
			fail ("ERROR Nula: " + ex.getMessage());
		}		
	}
	
	@Test
	public void testAbsolutAmbLlindar() throws Exception {
		float descompte = 2.00f;
		float llindar = 10.00f;
		float esperat = DINERS - descompte;
		try {
			Estrategia = new EstrategiaDescompteVendaAbsolut( descompte, llindar );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda amb llindar: " + totalVenda);
	        assertEquals (totalVenda, esperat, ERRORACCEPTAT);
		} catch (Exception ex) {
			fail ("ERROR Absolut: " + ex.getMessage());
		}		
	}
	
	@Test
	public void testAbsolut() {
		float descompte = 2.00f;
		float llindar = 100.00f;
		float esperat = DINERS;
		try {
			Estrategia = new EstrategiaDescompteVendaAbsolut( descompte, llindar );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda sense superar el llindar: " + totalVenda);
	        assertEquals (totalVenda, esperat, ERRORACCEPTAT);
		} catch (Exception ex) {
			fail ("ERROR Absolut: " + ex.getMessage());
		}		
	}

	@Test
	public void testPercentatge() {
		float percentatge = 0.1f;
		float esperat = DINERS * (1-percentatge);
		try {
			Estrategia = new EstrategiaDescompteVendaPercentatge( percentatge );
	        float totalVenda = Estrategia.getTotal(vendaFicticia);
	        System.out.println ("Import Total de la venda amb percentatge: " + totalVenda);
	        assertEquals (totalVenda, esperat, ERRORACCEPTAT);
		} catch (Exception ex) {
			fail ("ERROR Absolut: " + ex.getMessage());
		}		
	}
}