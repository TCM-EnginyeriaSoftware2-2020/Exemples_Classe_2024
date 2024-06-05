package CapaAplicacio;

import CapaDomini.Mobles.ICadira;
import CapaDomini.Mobles.ISofa;
import CapaDomini.Mobles.ITaula;

import java.lang.reflect.Method;

public interface IAbstractFactory {
    public abstract ICadira createCadira();
    public abstract ISofa createSofa();
    public abstract ITaula createTaula();

    public static IAbstractFactory getInstance(EFamily laFamilia) throws Exception{
        Class laClasse;
        Method elMetode;

        laClasse = Class.forName("CapaAplicacio.Factoria"+laFamilia);
        elMetode = laClasse.getMethod("getInstanciaUnica");
        return (IAbstractFactory) elMetode.invoke(null);

    }
}
