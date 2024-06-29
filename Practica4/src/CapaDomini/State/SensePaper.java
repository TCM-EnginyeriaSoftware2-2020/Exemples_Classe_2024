package CapaDomini.State;

public final class SensePaper implements IEstat{
    private static SensePaper intanciaUnica = new SensePaper();
    private SensePaper(){}

    public static SensePaper getIntanciaUnica() {
        return intanciaUnica;
    }

    @Override
    public IEstat peticioImpressio(Boolean potImprimir) {
        throw new RuntimeException("Impressora sense fulls.");
    }

    @Override
    public IEstat fiImpressio(Boolean calNeteja) {
        throw new RuntimeException("Impressora sense fulls");
    }

    @Override
    public IEstat fiNeteja() {
        throw new RuntimeException("Impressora sense fulls");
    }

    @Override
    public IEstat carregarFulls() {
        return StandBy.getInstanciaUnica();
    }

    public String toString(){
        return "impressora sense paper";
    }
}
