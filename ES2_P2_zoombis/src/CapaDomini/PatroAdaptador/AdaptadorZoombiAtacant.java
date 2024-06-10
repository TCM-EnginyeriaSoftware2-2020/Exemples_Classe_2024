package CapaDomini.PatroAdaptador;

import CapaDomini.ZoombiAtacant;


public class AdaptadorZoombiAtacant implements IZoombi {

	private ZoombiAtacant zombi;

	public AdaptadorZoombiAtacant(int[] args) {
		if (args.length != 2)
			throw new IllegalArgumentException("Paràmetre d'entrada no vàlid");

		zombi = new ZoombiAtacant(args[0], args[1]);
	}

	@Override
	public boolean moure(int posicioEnemic) {
		return zombi.getPosicio() == posicioEnemic;
	}

	@Override
	public int getDamage() {
		return zombi.getDamage();
	}

	@Override
	public int getPosicio() {
		return zombi.getPosicio();
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	public String toString() {
		return "Atacant a " +  zombi.getPosicio() + " fa dany " + zombi.getDamage();
	}
}
