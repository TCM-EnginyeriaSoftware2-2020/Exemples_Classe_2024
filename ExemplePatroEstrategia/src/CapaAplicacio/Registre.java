package CapaAplicacio;

import CapaDomini.IServeisPersistenciaVenda;
import CapaDomini.Venda;
import CapaPersistencia.SimulacioBBDD.SimulacioBBDDDescomptesPreusVenda;


public class Registre {

	private Venda vendaActual;
	private static IServeisPersistenciaVenda persistencia;

	public Registre(IServeisPersistenciaVenda bbdd) {
		persistencia = bbdd;
		vendaActual = new Venda();
	}
	
	public Registre() {
		this (new SimulacioBBDDDescomptesPreusVenda());
	}

	public float getTotalVenda() {
		return vendaActual.getTotal();
	}

	public String getDescompte() {
		return vendaActual.getDescompte();
	}
	
	static IServeisPersistenciaVenda getPersistencia () {
	    	return persistencia;
	    }
}