package CapaAplicacio;

import CapaDomini.EstrategiaDescompteVenda.EstrategiaDescompteVendaAbsolut;
import CapaDomini.EstrategiaDescompteVenda.IEstrategiaDescompteVenda;

public class FactoriaEstrategiaDescompteVendaAbsolut extends
		FactoriaAbstracteEstrategiaDescompteVenda {
	@Override
	protected IEstrategiaDescompteVenda obtenirEstrategiaDecompte() {
		
		float[] dades = Registre.getPersistencia().getDescompteAbsolut();
		
		return new EstrategiaDescompteVendaAbsolut(dades[0], dades[1]);
	}
}