package CapaAplicacio;

import java.lang.reflect.Constructor;

import CapaDomini.EstrategiaDescompteVenda.*;
import CapaPersistencia.FitxerLocal.ConfiguracioAplicacio;
import CapaPersistencia.FitxerLocal.ConfiguracioAplicacio2;


public abstract class FactoriaAbstracteEstrategiaDescompteVenda {

	private static IEstrategiaDescompteVenda estrategiaFixarPreuVenda;

	public static final IEstrategiaDescompteVenda getEstrategiaFixarPreuVenda() {
		if (estrategiaFixarPreuVenda == null) {
			try {
				String nomClasse = ConfiguracioAplicacio2.getProperty("nomFactoriaEstrategiaDescompte");
				Class unaClasse = Class.forName(nomClasse);
				Constructor unConstructor = unaClasse.getConstructors()[0];
				Object unObjecte = unConstructor.newInstance();
				FactoriaAbstracteEstrategiaDescompteVenda filla = (FactoriaAbstracteEstrategiaDescompteVenda) unObjecte; 
				return filla.obtenirEstrategiaDecompte();
				
			}
			catch (Exception e) {
				//Si no es pot crear una estratègia concreta, crearem l'estrategia nul·la (sense cap descompte)
				return new EstrategiaDescompteVendaNula(e.getMessage());
			}
		}
		return estrategiaFixarPreuVenda;
	}

	protected abstract IEstrategiaDescompteVenda obtenirEstrategiaDecompte();	
}