package CapaAplicacio;

class SubSystemA implements ISubSystem{

	private static SubSystemA instance;
	private SubSystemA () 
	{
		System.out.println("Sistema A operatiu");
	}
	//public SubSystemA( int i, double d) {}
	
	public static synchronized SubSystemA getInstance()
	{
		if( instance == null)
			instance = new SubSystemA();
		return instance;
	}

	public void execute()
	{
		System.out.println("\t S'executa el sistema A, qui executa el B i D:");
		System.out.print("\t");SubSystemB.getInstance().execute();
		System.out.print("\t");SubSystemD.getInstance().execute();
	}
	
}
