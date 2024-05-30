package domini;

import domini.PatroEstats.IEstats;

public class Casella {
	private final char contingut;
	private IEstats estat;
	/* Possibles estats 
	 * 0 - oculta, mostra TaulerMemory.celdaBuida
	 * 1 - visible, mostra el seu valor de manera temporal
	 * 2 - encertada, mostra el seu valor definitivament
	 */

	public Casella( char contingut)
	{
		this.contingut = contingut;
		this.estat = IEstats.getEstatInicial();
	}
	
	public char getContingut() {
		if(! this.estat.isVisible())
			return TaulerMemory.celdaBuida;
		return contingut;
	}
	
	public void setInvisible() {
		this.estat = this.estat.Amagar();
	}
	
	public void setVisible() {
		this.estat = this.estat.Destapar();
	}
	
	public void setAcertada() {
		this.estat = this.estat.Fixar();
	}
	
}
