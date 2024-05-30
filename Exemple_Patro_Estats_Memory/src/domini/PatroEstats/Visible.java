package domini.PatroEstats;

public abstract class Visible  implements IEstats{


	@Override
	public IEstats Destapar() {
		throw new RuntimeException("No es pot fer");
	}
	
	@Override
	public boolean isVisible() {
		return true;
	}
	
}
