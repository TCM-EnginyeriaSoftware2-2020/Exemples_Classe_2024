package CapaAplicacio;

 class SubSystemC  implements ISubSystem{

	private static SubSystemC instance;
	private SubSystemC () 
	{
		System.out.println("Sistema C operatiu");
	}
	
	public static synchronized SubSystemC getInstance()
	{
		if( instance == null)
			instance = new SubSystemC();
		return instance;
	}
	
	public void execute()
	{
		System.out.println("\t S'executa el sistema C, qui executa el D");
		System.out.print("\t");SubSystemD.getInstance().execute();
	}
	
}
