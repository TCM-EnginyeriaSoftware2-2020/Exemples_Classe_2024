package CapaDomini.PatroAdaptador;

import CapaDomini.ZoombiAmagat;


public class AdaptadorZoombiAmagat implements IZoombi {

	private ZoombiAmagat zombi;

	public AdaptadorZoombiAmagat(int[] args) {
		if (args.length != 1)
			throw new IllegalArgumentException("Par�metre d'entrada no v�lid");

		zombi = new ZoombiAmagat(args[0]);
	}

	@Override
	public boolean moure(int posicioEnemic) {
		return zombi.getPosicio() == posicioEnemic;
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public int getPosicio(){
		return zombi.getPosicio();
	}

	@Override
	public boolean isVisible() {
		return zombi.isVisible();
	}

	public String toString() {
		return "Amagat a " + zombi.getPosicio();
	}
}
