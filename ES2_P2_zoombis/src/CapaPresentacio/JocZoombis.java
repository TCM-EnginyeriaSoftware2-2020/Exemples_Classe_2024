package CapaPresentacio;

import CapaAplicacio.ETipusZoombi;
import CapaAplicacio.FactoriaSingleton;
import CapaDomini.PatroAdaptador.IZoombi;
import CapaDomini.Personatge;

import java.util.ArrayList;
import java.util.Scanner;

public class JocZoombis {

	private final static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Juguem!");

		FactoriaSingleton factoriaUnica = FactoriaSingleton.getInstance();

		Personatge personatge = new Personatge();

		ArrayList<IZoombi> llistatZombis = new ArrayList<>();
		for (ETipusZoombi elTipus : ETipusZoombi.values()) {
			llistatZombis.add(factoriaUnica.getZoombi(elTipus));
		}

		while (personatge.getVida() > 0) {
			moure(personatge);

			for (IZoombi zombi : llistatZombis) {

				if (personatge.getPosicio() == zombi.getPosicio()) {
					System.out.println("Has trobat un zoombi del tipus " + zombi);
					personatge.setVida(zombi.getDamage());
				} else if (zombi.moure(personatge.getPosicio())) {
					System.out.println("Un caminant s'ha mogut i t'ha atrapat");
					personatge.setVida(zombi.getDamage());
				}

			}
		}
		System.out.println("Has mort");
	}

	private static void moure(Personatge personatge) {
		System.out.println("Vols moure?\n 1.- moviment a l'esquerra \n 2.- moviment a la dreta \n 3.- quiet");
		String input = myScanner.nextLine();
		switch (input) {
		case "3": break;
		case "1":
			personatge.setPosicio(personatge.getPosicio() - 1);
			break;
		case "2":
			personatge.setPosicio(personatge.getPosicio() + 1);
			break;
		default:
			moure(personatge);
		}

	}

}
