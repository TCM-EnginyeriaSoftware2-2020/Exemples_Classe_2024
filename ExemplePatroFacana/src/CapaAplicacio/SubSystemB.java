package CapaAplicacio;

  class SubSystemB  implements ISubSystem{

	private static SubSystemB instance;
	private SubSystemB () 
	{
		System.out.println("Sistema B operatiu");
	}
	
	public static synchronized SubSystemB getInstance()
	{
		if( instance == null)
			instance = new SubSystemB();
		return instance;
	}
	
	public void execute()
	{

		System.out.println("\t S'executa el sistema B");
	}
	
}
