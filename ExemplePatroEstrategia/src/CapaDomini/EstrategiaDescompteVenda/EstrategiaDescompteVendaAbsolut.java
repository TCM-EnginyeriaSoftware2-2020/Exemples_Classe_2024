package CapaDomini.EstrategiaDescompteVenda;

import CapaDomini.Venda;

public class EstrategiaDescompteVendaAbsolut implements
		IEstrategiaDescompteVenda {

	private float descompte;
	private float llinda;

	public EstrategiaDescompteVendaAbsolut(float descompte, float llinda) {
		this.descompte = descompte;
		this.llinda = llinda;
	}

	@Override
	public float getTotal(Venda venda) {
		float subtotal = venda.getTotalAbansDte();
		if( subtotal < llinda)
			return subtotal;
		return subtotal - descompte;
	}

	public String toString() {
		return "Estrategia Descompte Absolut: Llinda = " + llinda
				+ ", descompte = " + descompte;
	}
}
