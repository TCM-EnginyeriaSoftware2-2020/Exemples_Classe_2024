package CapaAplicacio;

import CapaDomini.Mobles.*;

public final class FactoriaModerna implements IAbstractFactory{

    private final static IAbstractFactory instanciaUnica = new FactoriaModerna();
    private FactoriaModerna(){}
    public static IAbstractFactory getInstanciaUnica() { return instanciaUnica; }
    @Override
    public ICadira createCadira() {
        return new CadiraModern();
    }

    @Override
    public ISofa createSofa() {
        return new SofaModern();
    }

    @Override
    public ITaula createTaula() {
        return new TaulaModern();
    }
}
