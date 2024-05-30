package CapaPersistencia.FitxerLocal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguracioAplicacio2 {

	private static final String NOM_FITXER = "FitxerConfiguracio.properties";
	private static Properties propietatsAplicacio;
	
	private ConfiguracioAplicacio2() throws Exception 
	{
		FileInputStream f ;
		try{
			 f = new FileInputStream( NOM_FITXER );
			propietatsAplicacio = new Properties();
			propietatsAplicacio.load(f);
			f.close();
		}catch(IOException e)
		{
			throw new Exception("No es pot llegir el fitxer local " + e.getMessage());
		}
	}
	
	public synchronized static String getProperty( String key ) throws Exception 
	{
		if(propietatsAplicacio == null)
			new ConfiguracioAplicacio2();
		return propietatsAplicacio.getProperty(key);
	}
	
	public synchronized static void setProperty( String key, String value ) throws Exception 
	{
		if(propietatsAplicacio == null)
			new ConfiguracioAplicacio2();
		propietatsAplicacio.setProperty(key, value);
		
	}
}
