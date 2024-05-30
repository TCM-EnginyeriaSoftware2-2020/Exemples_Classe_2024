package CapaDomini.EstrategiaDescompteVenda;

import CapaDomini.Venda;

public class EstrategiaDescompteVendaPercentatge implements
		IEstrategiaDescompteVenda {

	private float percentatge;

	public EstrategiaDescompteVendaPercentatge(float percentatge) {
		this.percentatge = percentatge;
	}

	@Override
	public float getTotal(Venda venda) {
		/*
		 * import = 80.50
		 * descompte del 10% = 8
		 * import després 80.50 - 8 = 72.50
		 */
		return venda.getTotalAbansDte()* (1-percentatge);
	}

	public String toString() {
		return "Estrategia Descompte Percentatge = " + percentatge;
	}
}