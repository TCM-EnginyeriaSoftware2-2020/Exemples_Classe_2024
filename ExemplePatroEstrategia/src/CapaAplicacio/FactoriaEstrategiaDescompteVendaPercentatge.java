package CapaAplicacio;

import java.util.Calendar;

import CapaDomini.EstrategiaDescompteVenda.EstrategiaDescompteVendaPercentatge;
import CapaDomini.EstrategiaDescompteVenda.IEstrategiaDescompteVenda;

public class FactoriaEstrategiaDescompteVendaPercentatge extends
		FactoriaAbstracteEstrategiaDescompteVenda {

	@Override
	protected IEstrategiaDescompteVenda obtenirEstrategiaDecompte() {
		Calendar avui = Calendar.getInstance();
		int diaSetmana = avui.get(Calendar.DAY_OF_WEEK);
		System.out.println("dia "+ diaSetmana);
		float percentatge = Registre.getPersistencia().getDescomptePercentatge(diaSetmana);
		return new EstrategiaDescompteVendaPercentatge(percentatge);
	}
}