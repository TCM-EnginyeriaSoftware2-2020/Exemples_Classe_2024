package CapaDomini.State;

public final class StandBy implements IEstat{
    private static StandBy instanciaUnica = new StandBy();
    private StandBy(){}

    public static StandBy getInstanciaUnica() {
        return instanciaUnica;
    }

    @Override
    public IEstat peticioImpressio(Boolean potImprimir) {
        if (potImprimir){
            return Imprimint.getInstanciaUnica();
        }
        return SensePaper.getIntanciaUnica();
    }

    @Override
    public IEstat fiImpressio(Boolean calNeteja) {
        throw new RuntimeException("No es pot fer.");
    }

    @Override
    public IEstat fiNeteja() {
        throw new RuntimeException("No es pot fer");
    }

    @Override
    public IEstat carregarFulls() {
        return this;
    }

    public String toString(){
        return "impressora ready";
    }
}
