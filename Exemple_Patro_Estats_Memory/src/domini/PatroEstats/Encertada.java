package domini.PatroEstats;

public class Encertada extends Visible{


	@Override
	public IEstats Amagar() {
		throw new RuntimeException("No es pot fer");
	}

	@Override
	public IEstats Fixar() {
		throw new RuntimeException("No es pot fer");
	}
	


}
