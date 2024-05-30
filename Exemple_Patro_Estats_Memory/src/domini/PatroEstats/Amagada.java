package domini.PatroEstats;

public class Amagada implements IEstats{

	@Override
	public IEstats Destapar() {
		return new Destapada();
	}

	@Override
	public IEstats Amagar() {
		throw new RuntimeException("Ja està amagada");
	}

	@Override
	public IEstats Fixar() {
		throw new RuntimeException("No es pot fer");
	}
	@Override
	public boolean isVisible() {
		return false;
	}

}
