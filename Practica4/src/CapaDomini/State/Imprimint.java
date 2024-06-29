package CapaDomini.State;

public final class Imprimint implements IEstat{

    private static Imprimint instanciaUnica = new Imprimint();
    private Imprimint(){}

    public static Imprimint getInstanciaUnica() {
        return instanciaUnica;
    }

    @Override
    public IEstat peticioImpressio(Boolean potImprimir)
        {
            throw new RuntimeException("Impressora està ocupada imprimint.");
        }

    @Override
    public IEstat fiImpressio(Boolean calNeteja) {
        if (calNeteja){
            return new Netejant();
        }
        return StandBy.getInstanciaUnica();
    }

    @Override
    public IEstat fiNeteja() {
        throw new RuntimeException("Impressora està ocupada imprimint.");
    }

    @Override
    public IEstat carregarFulls() {
        throw new RuntimeException("Impressora està ocupada imprimint.");
    }

    public String toString(){
        return "impressora imprimint";
    }
}
