package domini.PatroEstats;

public interface IEstats {
	
	public abstract IEstats Destapar();
	public abstract IEstats Amagar();
	public abstract IEstats Fixar();
	public abstract boolean isVisible();
	
	public static IEstats getEstatInicial()
	{
		return new Amagada();
	}
}
