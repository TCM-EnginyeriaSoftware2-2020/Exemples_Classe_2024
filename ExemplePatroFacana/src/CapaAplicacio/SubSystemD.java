package CapaAplicacio;

 class SubSystemD  implements ISubSystem{

	private static SubSystemD instance;
	private SubSystemD () 
	{
		System.out.println("Sistema D operatiu");
	}
	
	public static synchronized SubSystemD getInstance()
	{
		if( instance == null)
			instance = new SubSystemD();
		return instance;
	}
	
	public void execute()
	{
		System.out.println("\t S'executa el sistema D");
	}
	
}
