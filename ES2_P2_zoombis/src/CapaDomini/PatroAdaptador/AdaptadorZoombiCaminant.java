package CapaDomini.PatroAdaptador;

import java.lang.reflect.Field;

import CapaDomini.ZoombiCaminant;

public class AdaptadorZoombiCaminant implements IZoombi {

	private ZoombiCaminant zombi;

	public AdaptadorZoombiCaminant(int[] args) {
		if (args.length != 2)
			throw new IllegalArgumentException("Paràmetre d'entrada no vàlid");

		zombi = new ZoombiCaminant(args[0], args[1]);
	}

	@Override
	public boolean moure(int posicioEnemic) {
		return zombi.moure(posicioEnemic);
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public int getPosicio() {
		try {
			Field privateField = ZoombiCaminant.class.getDeclaredField("posicio");
			privateField.setAccessible(true);
			return (int) privateField.get(zombi);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error posició del zombi: AdaptadorZoombiCaminant");
		}
	}

	@Override
	public boolean isVisible() {
		return true;
	}
	
	public String toString() {
		return "Caminant a " + getPosicio();
	}

}
