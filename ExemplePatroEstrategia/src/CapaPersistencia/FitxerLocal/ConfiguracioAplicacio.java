package CapaPersistencia.FitxerLocal;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguracioAplicacio {

	private static ConfiguracioAplicacio instance;
	private final String NOM_FITXER = "FitxerConfiguracio.properties";
	private Properties propietatsAplicacio;
	
	private ConfiguracioAplicacio() throws Exception{
		FileInputStream f ;
		try{
			 f = new FileInputStream( NOM_FITXER );
			propietatsAplicacio = new Properties();
			
		}catch(IOException e)
		{
			throw new Exception("No es pot llegir el fitxer local " + e.getMessage());
		}
		propietatsAplicacio.load(f);
		f.close();
	}
	
	public synchronized static ConfiguracioAplicacio getInstance() throws Exception 
	{
		if(instance == null)
			instance = new ConfiguracioAplicacio();
		return instance;
	}
	
	public String getProperty( String key )
	{
		return propietatsAplicacio.getProperty(key);
	}
}
