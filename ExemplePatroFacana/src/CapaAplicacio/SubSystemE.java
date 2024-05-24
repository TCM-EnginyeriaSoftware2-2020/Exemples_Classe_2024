package CapaAplicacio;

 class SubSystemE  implements ISubSystem{

	private static SubSystemE instance;
	private SubSystemE () 
	{
		System.out.println("Sistema E operatiu");
	}
	
	public static synchronized SubSystemE getInstance()
	{
		if( instance == null)
			instance = new SubSystemE();
		return instance;
	}
	
	public void execute()
	{
		System.out.println("\t S'executa el sistema E, qui executa el B");
		System.out.print("\t");SubSystemB.getInstance().execute();
	}
	
}
