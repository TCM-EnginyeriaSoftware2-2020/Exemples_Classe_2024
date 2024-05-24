package View;


import CapaAplicacio.*;
import CapaAplicacio.Facade.Facade;

public class Clients_Main {

	public static void main(String[] args) {
		
		//clients();
		clientsFacade();
	}
	/*private static void clients() {
		// els clients fan el acc�s als subsistemes
		System.out.println("***El client C1 executa A i E");
		SubSystemA.getInstance().execute();
		SubSystemE.getInstance().execute();


		System.out.println("\n***El client C2 executa A i C");
		SubSystemA.getInstance().execute();
		SubSystemC.getInstance().execute();

		System.out.println("\n***El client C3 executa A i E");
		SubSystemA.getInstance().execute();
		SubSystemE.getInstance().execute();
	}*/
	

	private static void clientsFacade()
	{
		// els clients fan el acc�s als subsistemes
		System.out.println("***El client C1 executa A i E");
		Facade.execute(1,"D");
		Facade.execute(1,"E");
		//Facade f = new Facade();

		System.out.println("\n***El client C2 executa A i C");
		Facade.execute(2,"A");
		Facade.execute(2,"C");
		
		System.out.println("\n***El client C3 executa A i E");
		Facade.execute(3,"A");
		Facade.execute(3,"E");
	}

}
