package CapaAplicacio;

import CapaDomini.Mobles.*;

public final class FactoriaClassica implements IAbstractFactory{
    
    private final static IAbstractFactory instanciaUnica = new FactoriaClassica();
    private FactoriaClassica(){}
    public static IAbstractFactory getInstanciaUnica() { return instanciaUnica; }
    @Override
    public ICadira createCadira() {
        return new CadiraClassic();
    }

    @Override
    public ISofa createSofa() {
        return new SofaClassic();
    }

    @Override
    public ITaula createTaula() {
        return new TaulaClassic();
    }
}
