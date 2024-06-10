package CapaAplicacio;

import java.lang.reflect.Constructor;

import CapaDomini.PatroAdaptador.IZoombi;
import CapaPersistencia.FitxerProperties;

public final class FactoriaSingleton {

	private static FactoriaSingleton instanciaUnica;
	private final FitxerProperties myProperties;
	
	private FactoriaSingleton()
	{ myProperties = FitxerProperties.getInstance(); }
	
	public synchronized static FactoriaSingleton getInstance()
	{
		if( instanciaUnica == null) instanciaUnica = new FactoriaSingleton();
		return instanciaUnica;
	}
	
	public IZoombi getZoombi( ETipusZoombi elTipus, int[] args)
	{
		try {
			String nomClasse = "CapaDomini.PatroAdaptador.Adaptador" + elTipus.toString();
			Class<?> laClasse = Class.forName(nomClasse);
			Constructor<?> elConstructor = laClasse.getDeclaredConstructor(args.getClass());
			return (IZoombi) elConstructor.newInstance(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public IZoombi getZoombi( ETipusZoombi elTipus )
	{
		return this.getZoombi(elTipus, getRandomArgumentsZombi(elTipus));
	}
	
	public int[] getRandomArgumentsZombi(ETipusZoombi elTipus)
	{
		switch ( elTipus ) {
			case ZoombiAmagat: return new int[] {myProperties.getRandomPosicio()};
			case ZoombiAtacant: return new int[] {myProperties.getRandomPosicio(), myProperties.getRandomDamage()};
			case ZoombiCaminant: return new int[] {myProperties.getRandomPosicio(), myProperties.getRandomSpeed()};
		}
		return null;
	}
}
