package CapaAplicacio.Facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public final class Facade{
    private static Properties acces;
    private Facade(){}

    public static void execute(int client, String subSystem)
    {
        try {
            if( acces(client,subSystem))
                execute(subSystem);
            else
                throw new RuntimeException("no té acces");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void execute(String subSystem) throws Exception
    {
        //SubSystemA.getInstance().execute();
        subSystem = "CapaAplicacio.SubSystem"+ subSystem.toUpperCase();
        Class laClasse = Class.forName(subSystem);
        Method metodeEstatic = laClasse.getMethod("getInstance");
        Object elSubstistema = metodeEstatic.invoke(null);
        Method elMetode = laClasse.getMethod("execute");
        elMetode.invoke(elSubstistema);
    }
    private static boolean acces(int client, String subSystem) throws Exception{
        if(acces == null )
        {
            acces = new Properties();
            acces.load(new FileInputStream(new File("Files/AutoritzarAcces.propierty")));
        }
        String totsSubSistemes = acces.getProperty(String.valueOf(client));
        String[] llistatSubSistemes = totsSubSistemes.split(",");
        for( String unSubSistema : llistatSubSistemes)
        {
            if( unSubSistema.equals(subSystem)) return true;
        }
        return false;
    }
}