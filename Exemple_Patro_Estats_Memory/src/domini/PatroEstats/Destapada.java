package domini.PatroEstats;

public class Destapada extends Visible{



	@Override
	public IEstats Amagar() {
		return new Amagada();
		
	}

	@Override
	public IEstats Fixar() {
		return new Encertada();
		
	}



}
