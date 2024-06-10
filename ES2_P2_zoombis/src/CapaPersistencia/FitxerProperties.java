package CapaPersistencia;
import java.io.FileInputStream;
import java.util.Properties;

public final class FitxerProperties {

    /* Cal aplicar el patró singleton perquè no volem diferents objectes accedint a un fitxer*/

    private final Properties properties= new Properties();
    private static final FitxerProperties instanciaUnica = new FitxerProperties();

    private FitxerProperties(){
        try {
            properties.load(new FileInputStream("Files/BBDD.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static FitxerProperties getInstance(){return instanciaUnica;}

    public int getRandomPosicio()
    {
        int longitud = Integer.parseInt( (String) properties.get("longitud") );
        return (int) (Math.random() * longitud);
    }
    public int getRandomDamage()
    {
        int min = Integer.parseInt( (String) properties.get("min_atac") );
        int max = Integer.parseInt( (String) properties.get("max_atac") );
        return (int) (Math.random() * (max-min+1)) + min;
    }

    public int getRandomSpeed()
    {
        int min = Integer.parseInt( (String) properties.get("min_velocitat") );
        int max = Integer.parseInt( (String) properties.get("max_velocitat") );
        return (int) (Math.random() * (max-min+1)) + min;
    }
}
